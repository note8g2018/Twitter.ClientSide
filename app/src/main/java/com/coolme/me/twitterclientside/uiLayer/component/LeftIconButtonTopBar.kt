package com.coolme.me.twitterclientside.uiLayer.component

import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.navigation.NavController
import com.coolme.me.twitterclientside.uiLayer.theme.BarIcon

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun LeftIconButtonTopBar(navController: NavController)
{
    val keyboardController = LocalSoftwareKeyboardController.current
    IconButton(
        onClick = {
            keyboardController?.hide()
            navController.popBackStack()
        },
              )
    {
        Icon(
            modifier = Modifier.size(BarIcon),
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = "Backward",
            )
    }
}