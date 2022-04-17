package com.coolme.me.twitterclientside.dataLayer.repository

import com.coolme.me.twitterclientside.dataLayer.model.ResultSho
import com.coolme.me.twitterclientside.dataLayer.userInterface.ArticleLDB
import com.coolme.me.twitterclientside.dataLayer.userInterface.ArticleNetwork
import com.coolme.me.twitterclientside.dataLayer.userInterface.ArticleRepository
import com.coolme.me.twitterclientside.uiLayer.screen.article.ArticleUiState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

class ArticleRepositoryImpl @Inject constructor(
    private val network: ArticleNetwork,
    private val articleLDB: ArticleLDB,
                                              ) : ArticleRepository
{
    override suspend fun send(articleUiState: ArticleUiState): Flow<ResultSho<String>>
    {
        val result = network.saveArticle(articleUiState)
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
                            articleLDB.saveArticle(value.data)
                        }
                        job.join()
                        emit(ResultSho.Success(data = "Article Post Successfully"))
                    }
                }
            }
        }
    }
}