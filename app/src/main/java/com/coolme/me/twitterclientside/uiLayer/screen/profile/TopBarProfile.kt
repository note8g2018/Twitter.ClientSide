package com.coolme.me.twitterclientside.uiLayer.screen.profile

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.coolme.me.twitterclientside.uiLayer.component.LeftIconButtonTopBar
import com.coolme.me.twitterclientside.uiLayer.component.TopBar

@Composable
fun TopBarProfile(navController: NavController)
{
    TopBar(
        title = "Profile",
        leftIconButtonTopBar = { LeftIconButtonTopBar(navController = navController) }
          )
}