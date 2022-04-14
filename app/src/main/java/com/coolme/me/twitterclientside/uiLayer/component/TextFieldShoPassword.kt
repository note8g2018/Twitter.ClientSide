package com.coolme.me.twitterclientside.uiLayer.component

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Password
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation

@Composable
fun TextFieldShoPassword(
    password: String,
    onPasswordChange: (String) -> Unit,
    onSend: ()-> Unit,
                        )
{
    TextFieldSho(
        value = password,
        onValueChange = onPasswordChange,
        label = "Password",
        icon = Icons.Filled.Password,
        visualTransformation = PasswordVisualTransformation(mask = '*'),
        keyboardType = KeyboardType.Password,
        imeAction = ImeAction.Send,
        keyboardActions = KeyboardActions(
            onSend = {onSend()},
                                         )
                )
}