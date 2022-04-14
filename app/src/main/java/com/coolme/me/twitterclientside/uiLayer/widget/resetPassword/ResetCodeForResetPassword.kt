package com.coolme.me.twitterclientside.uiLayer.widget.resetPassword

import androidx.compose.runtime.Composable
import com.coolme.me.twitterclientside.uiLayer.screen.resetPassword.ResetPasswordVM
import com.coolme.me.twitterclientside.uiLayer.component.TextFieldShoUsername

@Composable
fun ResetCodeForResetPassword(
    vM: ResetPasswordVM,
                            )
{
    TextFieldShoUsername(
        label = "Reset Code",
        username = vM.uiState.resetCode,
        onUsernameChange = {vM.onResetCodeChange(newResetCode = it)},
                        )
}
