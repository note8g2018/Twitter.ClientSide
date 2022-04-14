package com.coolme.me.twitterclientside.dataLayer.userInterface

import com.coolme.me.twitterclientside.dataLayer.model.ResultSho
import com.coolme.me.twitterclientside.dataLayer.model.User
import com.coolme.me.twitterclientside.uiLayer.screen.forgetPassword.ForgetPasswordUiState
import com.coolme.me.twitterclientside.uiLayer.screen.registration.RegistrationUiState
import com.coolme.me.twitterclientside.uiLayer.screen.resetPassword.ResetPasswordUiState
import kotlinx.coroutines.flow.Flow

interface RegistrationNetwork : NetworkSho
{
   suspend fun registerUser(registrationUiState: RegistrationUiState): Flow<ResultSho<User>>

   suspend fun forgetPassword(forgetPasswordUiState: ForgetPasswordUiState)
        : Flow<ResultSho<String>>

    suspend fun resetPassword(resetPasswordUiState: ResetPasswordUiState)
        : Flow<ResultSho<String>>
}