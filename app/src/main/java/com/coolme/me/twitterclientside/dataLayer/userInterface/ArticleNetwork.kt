package com.coolme.me.twitterclientside.dataLayer.userInterface

import com.coolme.me.twitterclientside.dataLayer.model.ArticleRealm
import com.coolme.me.twitterclientside.dataLayer.model.ResultSho
import com.coolme.me.twitterclientside.uiLayer.screen.article.ArticleUiState
import kotlinx.coroutines.flow.Flow

interface ArticleNetwork : NetworkSho
{
    suspend fun saveArticle(articleUiState: ArticleUiState)
    : Flow<ResultSho<ArticleRealm>>
}