package com.coolme.me.twitterclientside.uiLayer.screen.logout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Logout
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.coolme.me.twitterclientside.uiLayer.theme.Error
import com.coolme.me.twitterclientside.uiLayer.theme.OnGreenButton
import com.coolme.me.twitterclientside.uiLayer.theme.StyleGreenButton

@Composable
fun Logout(
    navController: NavController,
    vM: LogoutVM = hiltViewModel(),
    scaffoldState: ScaffoldState,
          )
{

    Box(
        modifier = Modifier.fillMaxSize()
       )
    {
        TextButton(
            onClick = { vM.logout(scaffoldState, navController) },
            modifier = Modifier
                    .background(color = Error)
                  )
        {
            Icon(
                imageVector = Icons.Filled.Logout,
                contentDescription = "Logout",
                tint = OnGreenButton,
                )
            Text(
                text = "Logout",
                style = StyleGreenButton,
                )
        }
    }
}