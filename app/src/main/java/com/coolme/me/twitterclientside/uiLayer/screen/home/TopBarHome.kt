package com.coolme.me.twitterclientside.uiLayer.screen.home

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.coolme.me.twitterclientside.uiLayer.component.LeftIconButtonTopBar
import com.coolme.me.twitterclientside.uiLayer.component.TopBar

@Composable
fun TopBarHome(navController: NavController)
{
    TopBar(
        title = "Home",
        leftIconButtonTopBar = { LeftIconButtonTopBar(navController = navController) }
          )
}