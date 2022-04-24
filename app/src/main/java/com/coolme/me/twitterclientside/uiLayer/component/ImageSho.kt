package com.coolme.me.twitterclientside.uiLayer.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.coolme.me.twitterclientside.R
import com.coolme.me.twitterclientside.dataLayer.model.Screen

@Composable
fun ImageSho(navController: NavController)
{
    Image(
        painter = painterResource(id = R.drawable.ic_user),
        contentDescription = "Image",
        modifier = Modifier.clickable {
            //FeatureThatRequiresCameraPermission()
            navController.navigate(Screen.MainContent.route)
        }
            .size(200.dp)
         )
}