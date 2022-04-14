package com.coolme.me.twitterclientside.uiLayer.screen.login

import kotlinx.serialization.Serializable

@Serializable
data class LoginUiState(
    val username : String = "",
    val password : String = "",
    val usernameHasError : Boolean = false,
    val passwordHasError : Boolean = false,
    val progressing : Boolean = false,
    val shouldShowSnackBar: Boolean = false,
                              )
{
    fun toJson(): Map<String, Any>
    {
        return mapOf(
            "username" to username,
            "password" to password,
                    )
    }
}
