package com.coolme.me.twitterclientside.dataLayer.network

import com.coolme.me.twitterclientside.dataLayer.model.*
import com.coolme.me.twitterclientside.dataLayer.userInterface.LoginNetwork
import com.coolme.me.twitterclientside.uiLayer.screen.login.LoginUiState
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LoginNetworkImpl @Inject constructor() : LoginNetwork
{
    override suspend fun login(loginUiState: LoginUiState): Flow<ResultSho<User>>
    {
        val ktorClient = KtorClient()
        return flow {
            emit(ResultSho.Progressing)
            try
            {
                val responseSho: ResponseSho<User> = ktorClient.httpClient.use {
                    it.post {
                        this.url {
                            this.path("login")
                        }
                        this.setBody(loginUiState.toJson())
                        //this.body = loginUiState.toJson()
                    }
                }.body()
                //ktorClient.httpClient.close()
                if (responseSho.error)
                {
                    emit( ResultSho.Failure(ErrorSho(
                        error = true,
                        statusCode = responseSho.statusCode,
                        message = responseSho.errorMessage!!,
                        type = "Server Side",
                                                    )
                                           )
                        )
                }
                else
                {
                    val user: User = responseSho.data as User
                    user.token = responseSho.token!!
                    emit(ResultSho.Success(data = user))
                }

            }
            catch (e :Exception)
            {
                emit( ResultSho.Failure(ErrorSho(
                    error = true,
                    statusCode = 700,
                    message = e.message!!,
                    type = "Client Side",
                                                )
                                       )
                    )
            }
        }
    }

    override suspend fun logout(user: User): Flow<ResultSho<User>>
    {
        val ktorClient = KtorClient()
        return flow {
            emit(ResultSho.Progressing)
            try
            {
                val responseSho: ResponseSho<User> = ktorClient.httpClient.use {
                    it.post {
                        this.url {
                            this.path("logout")
                        }
                        //this.body = user
                        this.setBody(user)
                    }
                }.body()
                //ktorClient.httpClient.close()
                if (responseSho.error)
                {
                    emit( ResultSho.Failure(ErrorSho(
                        error = true,
                        statusCode = responseSho.statusCode,
                        message = responseSho.errorMessage!!,
                        type = "Server Side",
                                                    )
                                           )
                        )
                }
                else
                {
                    val user2: User = responseSho.data as User
                    //user2.token = responseSho.token!!
                    emit(ResultSho.Success(data = user2))
                }

            }
            catch (e :Exception)
            {
                emit( ResultSho.Failure(ErrorSho(
                    error = true,
                    statusCode = 700,
                    message = e.message!!,
                    type = "Client Side",
                                                )
                                       )
                    )
            }
        }
    }

    override suspend fun getUserPhoneFromServer(token: String): Flow<ResultSho<UserRealm>>
    {
        val ktorClient = KtorClient()
        return flow {
            emit(ResultSho.Progressing)
            try
            {
                val responseSho: ResponseSho<UserRealm> = ktorClient.httpClient.use {
                    it.post {
                        this.url {
                            this.path("user")
                        }
                        this.setBody(token)
                    }
                }.body()
                if (responseSho.error)
                {
                    emit( ResultSho.Failure(ErrorSho(
                        error = true,
                        statusCode = responseSho.statusCode,
                        message = responseSho.errorMessage!!,
                        type = "Server Side",
                                                    )
                                           )
                        )
                }
                else
                {
                    val userPhone: UserRealm = responseSho.data as UserRealm
                    userPhone.token = responseSho.token!!
                    emit(ResultSho.Success(data = userPhone))
                }

            }
            catch (e :Exception)
            {
                emit( ResultSho.Failure(ErrorSho(
                    error = true,
                    statusCode = 700,
                    message = e.message!!,
                    type = "Client Side",
                                                )
                                       )
                    )
            }
        }
    }
}