package com.coolme.me.twitterclientside.uiLayer.widget.registration

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.coolme.me.twitterclientside.uiLayer.theme.StyleRole

@Composable
fun PasswordRule()
{
    Row()
    {
        Text(
            text = "1. ",
            style = StyleRole,
            )
        Text(
            text = "At least 8 characters [8, 31]",
            style = StyleRole,
            )
    }
    Row()
    {
        Text(
            text = "2. ",
            style = StyleRole,
            )
        Text(
            text = "Must be from [a, z] or [A, Z] or [0, 9] or " +
                    "[ ! @ # $ % ^ & * ( ) - _ = + ]",
            style = StyleRole,
            )
    }
}