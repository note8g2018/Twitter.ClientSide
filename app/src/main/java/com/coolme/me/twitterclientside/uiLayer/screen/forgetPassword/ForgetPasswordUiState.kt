package com.coolme.me.twitterclientside.uiLayer.screen.forgetPassword

import kotlinx.serialization.Serializable

@Serializable
data class ForgetPasswordUiState(
    val username : String = "",
    val usernameHasError : Boolean = false,
    val progressing : Boolean = false,
    val shouldShowSnackBar: Boolean = false,
                                )
{
    fun toJson(): Map<String, Any>
    {
        return mapOf(
            "username" to username,
                    )
    }
}
