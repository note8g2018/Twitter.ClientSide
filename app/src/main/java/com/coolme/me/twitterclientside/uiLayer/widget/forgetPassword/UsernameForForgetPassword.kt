package com.coolme.me.twitterclientside.uiLayer.widget.forgetPassword

import androidx.compose.runtime.Composable
import com.coolme.me.twitterclientside.uiLayer.screen.forgetPassword.ForgetPasswordVM
import com.coolme.me.twitterclientside.uiLayer.component.TextFieldShoUsername

@Composable
fun UsernameForForgetPassword(
    vM: ForgetPasswordVM,
                    )
{
    TextFieldShoUsername(
        username = vM.uiState.username,
        onUsernameChange = {vM.onUsernameChange(newUsername = it)},
                        )
}
