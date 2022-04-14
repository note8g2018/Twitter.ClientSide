package com.coolme.me.twitterclientside.uiLayer.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.coolme.me.twitterclientside.uiLayer.theme.TopBar
import com.coolme.me.twitterclientside.uiLayer.theme.TopBarContent

@Composable
fun TopBar(
    title : String,
    leftIconButtonTopBar: @Composable () -> Unit = {},
    rightIconButtonTopBar: @Composable () -> Unit = {},
          )
{
    TopAppBar(
        contentColor = TopBarContent,
        modifier = Modifier.fillMaxWidth()
             )
    {
        Box(modifier = Modifier.fillMaxWidth())
        {
            leftIconButtonTopBar()
            Box(
                Modifier.align(Alignment.Center)
               )
            {
                Text(
                    text = title,
                    textAlign = TextAlign.Center,
                    maxLines = 1,
                    style = TopBar,
                    )
            }
            rightIconButtonTopBar()
        }
    }
}
