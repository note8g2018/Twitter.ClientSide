package com.coolme.me.twitterclientside.uiLayer.screen.registration

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
import com.coolme.me.twitterclientside.domainLayer.validation.isEmailValid
import com.coolme.me.twitterclientside.domainLayer.validation.isPasswordValid
import com.coolme.me.twitterclientside.domainLayer.validation.isUsernameValid
import com.coolme.me.twitterclientside.uiLayer.component.SnackBarController
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class RegistrationVM @Inject constructor(
    private val repository: RegistrationRepository
                                        ) : ViewModel()
{
    var uiState by mutableStateOf(RegistrationUiState())
        private set

    private val snackBarController = SnackBarController(viewModelScope)

    fun onUsernameChange(newUsername: String)
    {
        uiState = uiState.copy(username = newUsername)
    }
    fun validateUsername()
    {
        uiState = uiState.copy(usernameHasError = !isUsernameValid(
            username = uiState.username)
                              )
    }
    fun onPassword1Change(newPassword: String)
    {
        uiState = uiState.copy(password1 = newPassword)
    }
    fun onPassword2Change(newPassword: String)
    {
        uiState = uiState.copy(password2 = newPassword)
    }
    fun validatePassword()
    {
        uiState = uiState.copy(
            passwordHasError = !isPasswordValid(password1 = uiState.password1,
                                                password2 = uiState.password2)
                 )
    }
    fun onEmailChange(newEmail: String)
    {
        uiState = uiState.copy(email = newEmail)
    }
    private fun onProgressing(newProgressing: Boolean)
    {
        uiState = uiState.copy(progressing = newProgressing)
    }
    fun validateEmail()
    {
        uiState = uiState.copy(emailHasError = !isEmailValid(email= uiState.email))
    }

    fun onBackFromPassword()
    {
        onProgressing(false)
    }

    fun send(scaffoldState : ScaffoldState, navController: NavController)
    {
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                repository.submit(uiState)
                        .stateIn(
                            initialValue = ResultSho.Progressing,
                            scope = viewModelScope,
                            started = WhileSubscribed(5000),
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
                                    //navController.backQueue.clear()
                                    navController.navigate(Screen.Wall.route) {
                                        popUpTo(Screen.Registration.route){
                                            inclusive = true }
                                    }
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