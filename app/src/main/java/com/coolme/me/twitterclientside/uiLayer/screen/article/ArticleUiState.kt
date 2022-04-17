package com.coolme.me.twitterclientside.uiLayer.screen.article

import kotlinx.serialization.Serializable

@Serializable
data class ArticleUiState(
    val token: String = "",
    val title : String = "",
    val body : String = "",
    val titleHasError : Boolean = false,
    val bodyHasError : Boolean = false,
    val progressing : Boolean = false,
    val shouldShowSnackBar: Boolean = false,
                      )
{
    fun toJson(): Map<String, Any>
    {
        return mapOf(
            "title" to title,
            "body" to body,
            "token" to token,
                    )
    }
}

