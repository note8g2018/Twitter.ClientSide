package com.coolme.me.twitterclientside.uiLayer.screen.wall

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.coolme.me.twitterclientside.uiLayer.component.RightIconButtonTopBar
import com.coolme.me.twitterclientside.uiLayer.component.TopBar

@Composable
fun TopBarWall(navController: NavController)
{
    TopBar(
        title = "Wall",
        rightIconButtonTopBar = { RightIconButtonTopBar(navController) }
          )
}