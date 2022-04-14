package com.coolme.me.twitterclientside.uiLayer.component

import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import com.coolme.me.twitterclientside.dataLayer.model.Screen
import com.coolme.me.twitterclientside.uiLayer.theme.BarIcon

@Composable
fun RightIconButtonTopBar(
    navController: NavController,
    imageVector: ImageVector = Icons.Filled.Home,
    contentDescription: String = "Home",
    onClick: () -> Unit = {navController.navigate(Screen.Home.route)},
                         )
{
    IconButton(
        onClick = onClick,
              )
    {
        Icon(
            modifier = Modifier.size(BarIcon),
            imageVector = imageVector,
            contentDescription = contentDescription,
            )
    }
}