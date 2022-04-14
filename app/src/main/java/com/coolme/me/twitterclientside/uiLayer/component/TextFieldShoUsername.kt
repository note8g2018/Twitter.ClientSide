package com.coolme.me.twitterclientside.uiLayer.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun TextFieldShoUsername(
    label: String = "Username",
    username: String,
    onUsernameChange: (String) -> Unit,
                        )
{
    TextFieldSho(
        value = username,
        onValueChange = onUsernameChange,
        label = label,
        icon = Icons.Filled.Create,
        keyboardType = KeyboardType.Text,
                )
}