package com.coolme.me.twitterclientside.uiLayer.screen.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coolme.me.twitterclientside.dataLayer.userInterface.RegistrationRepository
import com.coolme.me.twitterclientside.domainLayer.validation.isEmailValid
import com.coolme.me.twitterclientside.domainLayer.validation.isPasswordValid
import com.coolme.me.twitterclientside.domainLayer.validation.isUsernameValid
import com.coolme.me.twitterclientside.uiLayer.component.SnackBarController
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeVM @Inject constructor(
    private val repository: RegistrationRepository
                                        ) : ViewModel()
{
    var uiState by mutableStateOf(HomeUiState())
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

}