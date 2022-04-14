package com.coolme.me.twitterclientside.uiLayer.screen.registration

import kotlinx.serialization.Serializable

@Serializable
data class RegistrationUiState(
    val username : String = "",
    val email : String = "",
    val password1 : String = "",
    val password2 : String = "",
    val usernameHasError : Boolean = false,
    val passwordHasError : Boolean = false,
    val emailHasError : Boolean = false,
    val progressing : Boolean = false,
    val shouldShowSnackBar: Boolean = false,
                              )
{
    fun toJson(): Map<String, Any>
    {
        return mapOf(
            "username" to username,
            "email" to email,
            "password" to password1,
                    )
    }
}
