package com.coolme.me.twitterclientside.uiLayer.widget.resetPassword

import androidx.compose.runtime.Composable
import com.coolme.me.twitterclientside.uiLayer.screen.resetPassword.ResetPasswordVM
import com.coolme.me.twitterclientside.uiLayer.component.TextFieldShoUsername

@Composable
fun UsernameForResetPassword(
    vM: ResetPasswordVM,
                             )
{
    TextFieldShoUsername(
        username = vM.uiState.username,
        onUsernameChange = {vM.onUsernameChange(newUsername = it)},
                        )
}
