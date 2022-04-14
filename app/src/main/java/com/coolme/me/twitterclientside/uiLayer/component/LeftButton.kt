package com.coolme.me.twitterclientside.uiLayer.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.coolme.me.twitterclientside.uiLayer.theme.Error
import com.coolme.me.twitterclientside.uiLayer.theme.OnGreenButton
import com.coolme.me.twitterclientside.uiLayer.theme.StyleGreenButton

@Composable
fun RowScope.LeftButton(
    text: String = "Back",
    onBack: () -> Unit,
              )
{
    TextButton(
        onClick = onBack,
        modifier = Modifier
            .weight(weight = 1.0f, fill = true)
            .background(color = Error)
              )
    {
        Icon(
            imageVector = Icons.Filled.KeyboardArrowLeft,
            contentDescription = text,
            tint = OnGreenButton,
            )
        Text(
            text = text,
            style = StyleGreenButton,
            )
    }
}