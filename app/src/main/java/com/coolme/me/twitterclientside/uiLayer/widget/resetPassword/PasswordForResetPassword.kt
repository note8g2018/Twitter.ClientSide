package com.coolme.me.twitterclientside.uiLayer.widget.resetPassword

import androidx.compose.runtime.Composable
import com.coolme.me.twitterclientside.uiLayer.screen.resetPassword.ResetPasswordVM
import com.coolme.me.twitterclientside.uiLayer.component.TextFieldShoPassword

@Composable
fun PasswordForResetPassword(
    vM: ResetPasswordVM,
    onSend: ()-> Unit,
                    )
{
    TextFieldShoPassword(
        password = vM.uiState.newPassword,
        onPasswordChange = {vM.onNewPasswordChange(newNewPassword = it)},
        onSend = onSend,
                        )
}