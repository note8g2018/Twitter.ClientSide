package com.coolme.me.twitterclientside.uiLayer.screen.resetPassword

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.coolme.me.twitterclientside.uiLayer.component.LeftIconButtonTopBar
import com.coolme.me.twitterclientside.uiLayer.component.TopBar

@Composable
fun TopBarResetPassword(navController: NavController)
{
    TopBar(
        title = "Reset Password",
        leftIconButtonTopBar = { LeftIconButtonTopBar(navController = navController) }
          )
}