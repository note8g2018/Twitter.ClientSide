package com.coolme.me.twitterclientside.dataLayer.repository

import com.coolme.me.twitterclientside.dataLayer.model.ResultSho
import com.coolme.me.twitterclientside.dataLayer.model.User
import com.coolme.me.twitterclientside.dataLayer.userInterface.LocalDatabase
import com.coolme.me.twitterclientside.dataLayer.userInterface.LoginNetwork
import com.coolme.me.twitterclientside.dataLayer.userInterface.LoginRepository
import com.coolme.me.twitterclientside.uiLayer.screen.login.LoginUiState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val loginNetwork: LoginNetwork,
    private val localDatabase: LocalDatabase,
                                             ) : LoginRepository
{
    override suspend fun login(loginUiState: LoginUiState): Flow<ResultSho<User>>
    {
        val result = loginNetwork.login(loginUiState)
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

    override suspend fun logout(user: User): Flow<ResultSho<User>>
    {
        val result = loginNetwork.logout(user)
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
                            localDatabase.deleteUser(user)
                        }
                        job.join()
                        emit(value)
                    }
                }
            }
        }
    }
}