package com.coolme.me.twitterclientside.uiLayer.screen.article

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.coolme.me.twitterclientside.uiLayer.component.LeftIconButtonTopBar
import com.coolme.me.twitterclientside.uiLayer.component.TopBar

@Composable
fun TopBarArticle(navController: NavController)
{
    TopBar(
        title = "Article",
        leftIconButtonTopBar = { LeftIconButtonTopBar(navController = navController) }
          )
}