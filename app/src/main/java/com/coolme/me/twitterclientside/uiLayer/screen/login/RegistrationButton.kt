package com.coolme.me.twitterclientside.uiLayer.screen.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.coolme.me.twitterclientside.uiLayer.theme.Error
import com.coolme.me.twitterclientside.uiLayer.theme.StyleGreenButton

@Composable
fun RegistrationButton(
    onClick: ()-> Unit,
                      )
{
    TextButton(
        onClick = onClick,
        modifier = Modifier
                .fillMaxWidth()
                .background(color = Error)
              )
    {
        Text(
            text = "Register",
            style = StyleGreenButton,
            )
    }
}