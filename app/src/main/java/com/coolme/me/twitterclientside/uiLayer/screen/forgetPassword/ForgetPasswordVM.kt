package com.coolme.me.twitterclientside.uiLayer.screen.forgetPassword

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
import com.coolme.me.twitterclientside.dataLayer.userInterface.RegistrationRepository
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
class ForgetPasswordVM @Inject constructor(
    private val repository: RegistrationRepository,
                                          ) : ViewModel()
{
    var uiState by mutableStateOf(ForgetPasswordUiState())
        private set

    private val snackBarController = SnackBarController(viewModelScope)

    fun onUsernameChange(newUsername: String)
    {
        uiState = uiState.copy(username = newUsername)
    }
    private fun onProgressing(newProgressing: Boolean)
    {
        uiState = uiState.copy(progressing = newProgressing)
    }

    fun forgetPassword(scaffoldState : ScaffoldState, navController: NavController)
    {
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                repository.forgetPassword(uiState)
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
                                    navController.navigate(Screen.ResetPassword.route)
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