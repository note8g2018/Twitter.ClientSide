package com.coolme.me.twitterclientside.uiLayer.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.coolme.me.twitterclientside.uiLayer.theme.GreenButton
import com.coolme.me.twitterclientside.uiLayer.theme.OnGreenButton
import com.coolme.me.twitterclientside.uiLayer.theme.StyleGreenButton

@Composable
fun RowScope.RightButton(
    text: String = "Next",
    onNext: () -> Unit,
                        )
{
    TextButton(
        onClick = onNext,
        modifier = Modifier
            .weight(weight = 1.0f, fill = true)
            .background(color = GreenButton)
              )
    {
        Text(
            text = text,
            style = StyleGreenButton,
            )
        Icon(
            imageVector = Icons.Filled.KeyboardArrowRight,
            contentDescription = text,
            tint = OnGreenButton,
            )
    }
}