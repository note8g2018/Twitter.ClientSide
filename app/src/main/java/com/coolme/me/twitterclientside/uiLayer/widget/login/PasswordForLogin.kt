package com.coolme.me.twitterclientside.uiLayer.widget.login

import androidx.compose.runtime.Composable
import com.coolme.me.twitterclientside.uiLayer.screen.login.LoginVM
import com.coolme.me.twitterclientside.uiLayer.component.TextFieldShoPassword

@Composable
fun PasswordForLogin(
    vM: LoginVM,
    onSend: ()-> Unit,
            )
{
    TextFieldShoPassword(
        password = vM.uiState.password,
        onPasswordChange = {vM.onPasswordChange(newPassword = it)},
        onSend = onSend,
            )
}




