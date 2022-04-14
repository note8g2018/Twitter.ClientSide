package com.coolme.me.twitterclientside.uiLayer.widget.login

import androidx.compose.runtime.Composable
import com.coolme.me.twitterclientside.uiLayer.screen.login.LoginVM
import com.coolme.me.twitterclientside.uiLayer.component.TextFieldShoUsername

@Composable
fun UsernameForLogin(
    vM: LoginVM,
            )
{
    TextFieldShoUsername(
        username = vM.uiState.username,
        onUsernameChange = {vM.onUsernameChange(newUsername = it)},
            )
}
