package com.coolme.me.twitterclientside.uiLayer.screen.resetPassword

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.coolme.me.twitterclientside.uiLayer.theme.GreenButton
import com.coolme.me.twitterclientside.uiLayer.theme.StyleGreenButton

@Composable
fun ResetButton(
    onClick: () -> Unit,
                )
{
    TextButton(
        onClick = onClick,
        modifier = Modifier
                .fillMaxWidth()
                .background(color = GreenButton)
              )
    {
        Text(
            text = "Reset My Password",
            style = StyleGreenButton,
            )
    }
}