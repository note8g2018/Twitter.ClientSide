package com.coolme.me.twitterclientside.uiLayer.screen.registration

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.coolme.me.twitterclientside.uiLayer.component.LeftIconButtonTopBar
import com.coolme.me.twitterclientside.uiLayer.component.TopBar

@Composable
fun TopBarRegistration(navController: NavController)
{
    TopBar(
        title = "Registration",
        leftIconButtonTopBar = { LeftIconButtonTopBar(navController = navController) }
          )
}