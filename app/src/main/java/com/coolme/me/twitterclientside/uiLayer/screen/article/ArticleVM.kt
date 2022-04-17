package com.coolme.me.twitterclientside.uiLayer.screen.article

import androidx.compose.material.ScaffoldState
import androidx.compose.material.SnackbarDuration
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.coolme.me.twitterclientside.dataLayer.model.ResultSho
import com.coolme.me.twitterclientside.dataLayer.model.Screen
import com.coolme.me.twitterclientside.dataLayer.model.User
import com.coolme.me.twitterclientside.dataLayer.userInterface.ArticleRepository
import com.coolme.me.twitterclientside.dataLayer.userInterface.UserLDB
import com.coolme.me.twitterclientside.uiLayer.component.SnackBarController
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ArticleVM @Inject constructor(
    private val repository: ArticleRepository,
    userLDB: UserLDB,
                                ) : ViewModel()
{
    var uiState by mutableStateOf(ArticleUiState())
        private set

    var user by mutableStateOf<User?>(null)
        private set

    init
    {
        user = userLDB.getUser()
        uiState = uiState.copy(token = user?.token!!)
        println("called init")
    }

    private val snackBarController = SnackBarController(viewModelScope)

    fun onTitleChange(newTitle: String)
    {
        uiState = uiState.copy(title = newTitle)
    }
    fun onBodyChange(newBody: String)
    {
        uiState = uiState.copy(body = newBody)
    }
    private fun validateTitle()
    {
        uiState = uiState.copy( titleHasError = uiState.title.trim().isEmpty() )
    }
    private fun validateBody()
    {
        uiState = uiState.copy( bodyHasError = uiState.body.trim().isEmpty() )
    }
    private fun canSend(): Boolean
    {
        validateTitle()
        validateBody()
        if(uiState.titleHasError || uiState.bodyHasError)
        {
            return false
        }
        else
        {
            return true
        }
    }

    private fun onProgressing(newProgressing: Boolean)
    {
        uiState = uiState.copy(progressing = newProgressing)
    }

    fun send(scaffoldState : ScaffoldState, navController: NavController)
    {
        if(!canSend())
        {
            return
        }
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                repository.send(uiState)
                        .stateIn(
                            initialValue = ResultSho.Progressing,
                            scope = viewModelScope,
                            started = SharingStarted.WhileSubscribed(5000),
                                )
                        .onEach {
                            when (it)
                            {
                                is ResultSho.Progressing ->
                                {
                                    onProgressing(true)
                                    println("Progressing")
                                }
                                is ResultSho.Success     ->
                                {
                                    onProgressing(false)
                                    println("Success")
                                    snackBarController.getScope().launch {
                                        snackBarController.showSnackBar(
                                            scaffoldState = scaffoldState,
                                            message = it.data,
                                            duration = SnackbarDuration.Indefinite,
                                            actionLabel = "Hide",
                                                                       )
                                    }
                                    //navController.backQueue.clear()
                                    navController.navigate(Screen.Wall.route)
                                }
                                is ResultSho.Failure     ->
                                {
                                    onProgressing(false)
                                    println("Failure")
                                    snackBarController.getScope().launch {
                                        snackBarController.showSnackBar(
                                            scaffoldState = scaffoldState,
                                            message = it.errorSho.message,
                                            duration = SnackbarDuration.Indefinite,
                                            actionLabel = "Hide",
                                                                       )
                                    }

                                }
                            }
                        }.launchIn(viewModelScope)
            }

        }
    }
}
