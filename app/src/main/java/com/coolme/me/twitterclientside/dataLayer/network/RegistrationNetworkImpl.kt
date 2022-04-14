package com.coolme.me.twitterclientside.dataLayer.network

import com.coolme.me.twitterclientside.dataLayer.model.ErrorSho
import com.coolme.me.twitterclientside.dataLayer.model.ResponseSho
import com.coolme.me.twitterclientside.dataLayer.model.ResultSho
import com.coolme.me.twitterclientside.dataLayer.model.User
import com.coolme.me.twitterclientside.dataLayer.userInterface.RegistrationNetwork
import com.coolme.me.twitterclientside.uiLayer.screen.forgetPassword.ForgetPasswordUiState
import com.coolme.me.twitterclientside.uiLayer.screen.registration.RegistrationUiState
import com.coolme.me.twitterclientside.uiLayer.screen.resetPassword.ResetPasswordUiState
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RegistrationNetworkImpl @Inject constructor() : RegistrationNetwork
{
    override suspend fun registerUser(registrationUiState: RegistrationUiState)
    : Flow<ResultSho<User>>
    {
        val ktorClient = KtorClient()
        return flow {
            println("Flow")
            emit(ResultSho.Progressing)
            try
            {
                val responseSho: ResponseSho<User> = ktorClient.httpClient.use {
                    it.post {
                            this.url {
                                this.path("register")
                            }
                            this.setBody(registrationUiState.toJson())
                            //this.body = registrationUiState.toJson()
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

    override suspend fun forgetPassword(forgetPasswordUiState: ForgetPasswordUiState)
    : Flow<ResultSho<String>>
    {
        val ktorClient = KtorClient()
        return flow {
            println("Flow")
            emit(ResultSho.Progressing)
            try
            {
                val responseSho: ResponseSho<User> = ktorClient.httpClient.use {
                    it.post {
                        this.url {
                            this.path("forgotPassword")
                        }
                        this.setBody(forgetPasswordUiState.toJson())
                        //this.body = forgetPasswordUiState.toJson()
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
                    emit(ResultSho.Success(responseSho.result!!))
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

    override suspend fun resetPassword(resetPasswordUiState: ResetPasswordUiState)
    : Flow<ResultSho<String>>
    {
        val ktorClient = KtorClient()
        return flow {
            println("Flow")
            emit(ResultSho.Progressing)
            try
            {
                val responseSho: ResponseSho<User> = ktorClient.httpClient.use {
                    it.post {
                        this.url {
                            this.path("resetPassword")
                        }
                        this.setBody(resetPasswordUiState.toJson())
                        //this.body = resetPasswordUiState.toJson()
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
                    emit(ResultSho.Success(responseSho.result!!))
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
