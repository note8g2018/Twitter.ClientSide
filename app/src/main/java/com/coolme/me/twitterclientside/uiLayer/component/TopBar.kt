package com.coolme.me.twitterclientside.uiLayer.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.coolme.me.twitterclientside.uiLayer.theme.StyleTopBar
import com.coolme.me.twitterclientside.uiLayer.theme.TopBarContent

@Composable
fun TopBar(
    title : String,
    leftIconButtonTopBar: @Composable (() -> Unit)? = null,
    rightIconButtonTopBar: @Composable (() -> Unit)? = null,
          )
{
    TopAppBar(
        contentColor = TopBarContent,
        modifier = Modifier.fillMaxWidth()
             )
    {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
           )
        {
            NullableEmptyBox(box= leftIconButtonTopBar)
            Text(
                text = title,
                textAlign = TextAlign.Center,
                maxLines = 1,
                style = StyleTopBar,
                )
            NullableEmptyBox(box= rightIconButtonTopBar)
        }
    }
}
