package com.coolme.me.twitterclientside.uiLayer.screen.profile

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.coolme.me.twitterclientside.dataLayer.model.Screen
import com.coolme.me.twitterclientside.uiLayer.component.LeftIconButtonTopBar
import com.coolme.me.twitterclientside.uiLayer.component.RightIconButtonTopBar
import com.coolme.me.twitterclientside.uiLayer.component.TopBar

@Composable
fun TopBarProfile(navController: NavController)
{
    TopBar(
        title = "Profile",
        leftIconButtonTopBar = { LeftIconButtonTopBar(navController = navController) },
        rightIconButtonTopBar = {
            RightIconButtonTopBar(
                navController = navController,
                imageVector = Icons.Filled.Edit,
                contentDescription = "Edit",
                onClick = {navController.navigate(Screen.ProfileEdit.route)}
                                 )
                                },
          )
}