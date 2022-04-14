package com.coolme.me.twitterclientside.dataLayer.repository

import com.coolme.me.twitterclientside.dataLayer.model.ResultSho
import com.coolme.me.twitterclientside.dataLayer.model.User
import com.coolme.me.twitterclientside.dataLayer.userInterface.LocalDatabase
import com.coolme.me.twitterclientside.dataLayer.userInterface.RegistrationNetwork
import com.coolme.me.twitterclientside.dataLayer.userInterface.RegistrationRepository
import com.coolme.me.twitterclientside.uiLayer.screen.forgetPassword.ForgetPasswordUiState
import com.coolme.me.twitterclientside.uiLayer.screen.registration.RegistrationUiState
import com.coolme.me.twitterclientside.uiLayer.screen.resetPassword.ResetPasswordUiState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

class RegistrationRepositoryImpl @Inject constructor(
    private val registrationNetwork: RegistrationNetwork,
    private val localDatabase: LocalDatabase,
                                                    ) : RegistrationRepository
{
    override suspend fun submit(registrationUiState: RegistrationUiState)
    : Flow<ResultSho<User>>
    {
        val result = registrationNetwork.registerUser(registrationUiState)
        return flow {
            result.collect{value ->
                when (value)
                {
                    is ResultSho.Failure     ->
                    {
                        emit(value)
                    }
                    is ResultSho.Progressing ->
                    {
                        emit(value)
                    }
                    is ResultSho.Success     ->
                    {
                        val job: Job = CoroutineScope(Dispatchers.IO).launch {
                            localDatabase.saveOrUpdateUser(value.data)
                        }
                        job.join()
                        emit(value)
                    }
                }
            }
        }
    }

    override suspend fun forgetPassword(forgetPasswordUiState: ForgetPasswordUiState)
    : Flow<ResultSho<String>>
    {
        return registrationNetwork.forgetPassword(forgetPasswordUiState)
    }

    override suspend fun resetPassword(resetPasswordUiState: ResetPasswordUiState)
    : Flow<ResultSho<String>>
    {
        return registrationNetwork.resetPassword(resetPasswordUiState)
    }
}