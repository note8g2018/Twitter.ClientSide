package com.coolme.me.twitterclientside.uiLayer.screen.forgetPassword

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.coolme.me.twitterclientside.uiLayer.component.LeftIconButtonTopBar
import com.coolme.me.twitterclientside.uiLayer.component.TopBar

@Composable
fun TopBarForgetPassword(navController: NavController)
{
    TopBar(
        title = "Forget Password",
        leftIconButtonTopBar = { LeftIconButtonTopBar(navController = navController) }
          )
}