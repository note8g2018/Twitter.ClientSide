package com.coolme.me.twitterclientside.dataLayer.network

import com.coolme.me.twitterclientside.dataLayer.model.ArticleRealm
import com.coolme.me.twitterclientside.dataLayer.model.ErrorSho
import com.coolme.me.twitterclientside.dataLayer.model.ResponseSho
import com.coolme.me.twitterclientside.dataLayer.model.ResultSho
import com.coolme.me.twitterclientside.dataLayer.userInterface.ArticleNetwork
import com.coolme.me.twitterclientside.uiLayer.screen.article.ArticleUiState
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ArticleNetworkImpl @Inject constructor() : ArticleNetwork
{
    override suspend fun saveArticle(articleUiState: ArticleUiState)
    : Flow<ResultSho<ArticleRealm>>
    {
        val ktorClient = KtorClient()
        return flow {
            println("Flow")
            emit(ResultSho.Progressing)
            try
            {
                val responseSho: ResponseSho<ArticleRealm> = ktorClient.httpClient.use {
                    it.post {
                        this.url {
                            this.path("article")
                        }
                        this.setBody(articleUiState.toJson())
                    }
                }.body()
                //ktorClient.httpClient.close()
                if (responseSho.error)
                {
                    emit( ResultSho.Failure(
                        ErrorSho(
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
                    val articleRealm: ArticleRealm = responseSho.data as ArticleRealm
                    //user.token = responseSho.token!!
                    emit(ResultSho.Success(data = articleRealm))
                }

            }
            catch (e :Exception)
            {
                emit( ResultSho.Failure(
                    ErrorSho(
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