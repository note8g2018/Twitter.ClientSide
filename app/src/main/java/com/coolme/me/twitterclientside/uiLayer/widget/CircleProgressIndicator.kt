package com.coolme.me.twitterclientside.uiLayer.widget

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.coolme.me.twitterclientside.uiLayer.theme.CircleProgressSize
import com.coolme.me.twitterclientside.uiLayer.theme.UnfocusedBorderColor
import com.coolme.me.twitterclientside.uiLayer.theme.strokeWidthProgress

@Composable
fun BoxScope.CircleProgressIndicator()
{
    CircleProgressIndicator(
        size= CircleProgressSize,
        color= UnfocusedBorderColor,
        strokeWidth = strokeWidthProgress,
                                    )
}

@Composable
fun BoxScope.CircleProgressIndicator(
    size: Dp = 150.dp,
    color: Color = Color.Yellow,
    strokeWidth: Dp = 13.dp
                                    )
{
    Box(
        modifier = Modifier.align(Alignment.Center),
        contentAlignment = Alignment.Center,
          )
    {
        CircularProgressIndicator(
            modifier= Modifier.size(size),
            color = color,
            strokeWidth = strokeWidth,
                                 )
    }
}