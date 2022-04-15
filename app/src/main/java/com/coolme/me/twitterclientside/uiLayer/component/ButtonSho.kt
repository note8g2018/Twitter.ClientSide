package com.coolme.me.twitterclientside.uiLayer.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.coolme.me.twitterclientside.uiLayer.theme.GreenButton
import com.coolme.me.twitterclientside.uiLayer.theme.OnGreenButton
import com.coolme.me.twitterclientside.uiLayer.theme.StyleGreenButton

@Composable
fun ButtonSho(
    onClick: () -> Unit,
    color: Color = GreenButton,
    tint: Color = OnGreenButton,
    text: String,
    imageVector: ImageVector = Icons.Filled.KeyboardArrowRight,
             )
{
    TextButton(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .background(color = color)
              )
    {
        Text(
            text = text,
            style = StyleGreenButton,
            )
        Icon(
            imageVector = imageVector,
            contentDescription = text,
            tint = tint,
            )
    }
}