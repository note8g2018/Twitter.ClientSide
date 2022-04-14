package com.coolme.me.twitterclientside.uiLayer.screen.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.coolme.me.twitterclientside.uiLayer.theme.GreenButton
import com.coolme.me.twitterclientside.uiLayer.theme.PaddingAll
import com.coolme.me.twitterclientside.uiLayer.theme.StyleOutlinedButton

@Composable
fun ForgetPasswordButton(
    onClick: ()-> Unit,
                        )
{
    OutlinedButton(
        onClick = onClick,
        modifier = Modifier
                .padding(PaddingAll)
                .fillMaxWidth()
                .background(color = GreenButton)
                  )
    {
        Text(
            text = "I Forgot my Password",
            style = StyleOutlinedButton,
            )
    }
}