package com.coolme.me.twitterclientside.uiLayer.screen.logout

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
import com.coolme.me.twitterclientside.dataLayer.userInterface.LocalDatabase
import com.coolme.me.twitterclientside.dataLayer.userInterface.LoginRepository
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
class LogoutVM @Inject constructor(
    private val repository: LoginRepository,
    localDatabase: LocalDatabase,
                                 ) : ViewModel()
{
    var user by mutableStateOf<User?>(null)
        private set

    init
    {
        user = localDatabase.getUser()
        println("called init")
    }

    private val snackBarController = SnackBarController(viewModelScope)

    fun logout(scaffoldState : ScaffoldState, navController: NavController)
    {
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                repository.logout(user!!)
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
                                    println("Progressing")
                                }
                                is ResultSho.Success     ->
                                {
                                    println("Success")
                                    //navController.backQueue.clear()
                                    navController.navigate(Screen.Login.route){
                                        popUpTo(Screen.Wall.route){ inclusive = true }
                                    }
                                }
                                is ResultSho.Failure     ->
                                {
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