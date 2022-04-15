package com.coolme.me.twitterclientside.uiLayer.component

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.coolme.me.twitterclientside.uiLayer.theme.BarIcon

@Composable
fun NullableEmptyBox(
    box: @Composable (() -> Unit)? = null,
    size: Dp = BarIcon,
                    )
{
    if (box == null)
    {
        Spacer(Modifier.size(size))
    }
    else
    {
        box()
    }
}