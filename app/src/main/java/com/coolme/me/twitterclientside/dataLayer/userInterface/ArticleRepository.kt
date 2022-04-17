package com.coolme.me.twitterclientside.dataLayer.userInterface

import com.coolme.me.twitterclientside.dataLayer.model.ResultSho
import com.coolme.me.twitterclientside.uiLayer.screen.article.ArticleUiState
import kotlinx.coroutines.flow.Flow

interface ArticleRepository
{
    suspend fun send(articleUiState: ArticleUiState) : Flow<ResultSho<String>>
}