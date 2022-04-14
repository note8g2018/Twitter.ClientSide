package com.coolme.me.twitterclientside.uiLayer.screen.resetPassword

import kotlinx.serialization.Serializable

@Serializable
data class ResetPasswordUiState(
    val username : String = "",
    val usernameHasError : Boolean = false,
    val resetCode : String = "",
    val resetCodeHasError : Boolean = false,
    val newPassword : String = "",
    val newPasswordHasError : Boolean = false,
    val progressing : Boolean = false,
    val shouldShowSnackBar: Boolean = false,
                                )
{
    fun toJson(): Map<String, Any>
    {
        return mapOf(
            "username" to username,
            "resetCode" to resetCode,
            "newPassword" to newPassword,
                    )
    }
}
