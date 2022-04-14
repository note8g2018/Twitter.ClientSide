package com.coolme.me.twitterclientside.dataLayer.userInterface

import com.coolme.me.twitterclientside.dataLayer.model.ResultSho
import com.coolme.me.twitterclientside.dataLayer.model.User
import com.coolme.me.twitterclientside.uiLayer.screen.login.LoginUiState
import kotlinx.coroutines.flow.Flow

interface LoginRepository
{
    suspend fun login(loginUiState: LoginUiState) : Flow<ResultSho<User>>

    suspend fun logout(user: User) : Flow<ResultSho<User>>
}