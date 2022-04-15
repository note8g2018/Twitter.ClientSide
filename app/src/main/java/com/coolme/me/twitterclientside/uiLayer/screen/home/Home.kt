package com.coolme.me.twitterclientside.uiLayer.screen.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.coolme.me.twitterclientside.dataLayer.model.Screen
import com.coolme.me.twitterclientside.uiLayer.component.ButtonSho
import com.coolme.me.twitterclientside.uiLayer.component.SnackbarHostSho
import com.coolme.me.twitterclientside.uiLayer.screen.logout.Logout
import com.coolme.me.twitterclientside.uiLayer.screen.logout.LogoutVM
import com.coolme.me.twitterclientside.uiLayer.theme.PaddingColumn
import com.coolme.me.twitterclientside.uiLayer.theme.SpaceColumnHeight
import com.coolme.me.twitterclientside.uiLayer.widget.CircleProgressIndicator

@Composable
fun Home(
    navController: NavController,
                )
{
    Home(
        navController = navController,
        scaffoldState = rememberScaffoldState(),
                )
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Home(
    vM: HomeVM = hiltViewModel(),
    vMLogout: LogoutVM = hiltViewModel(),
    navController: NavController,
    scaffoldState: ScaffoldState,
                )
{
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            ,
        scaffoldState = scaffoldState,
        snackbarHost = {
            SnackbarHostSho(hostState = scaffoldState.snackbarHostState)
        },
        topBar = { TopBarHome(navController = navController) },
            )
    {
        Box( modifier = Modifier
            .padding(PaddingColumn)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
           )
        {
            Column(
                verticalArrangement = Arrangement.spacedBy(space = SpaceColumnHeight),
                modifier = Modifier.fillMaxSize()
                  )
            {
                Logout(
                    navController = navController,
                    scaffoldState = scaffoldState,
                      )
                ButtonSho(
                    onClick = { navController.navigate(Screen.Article.route) },
                    text = "Article"
                         )
            }

            if(vMLogout.progressing)
            {
                CircleProgressIndicator()
            }
        }
    }
}