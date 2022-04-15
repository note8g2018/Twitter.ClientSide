package com.coolme.me.twitterclientside.uiLayer.screen.article

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.coolme.me.twitterclientside.uiLayer.component.SnackbarHostSho
import com.coolme.me.twitterclientside.uiLayer.screen.registration.RegistrationVM
import com.coolme.me.twitterclientside.uiLayer.widget.CircleProgressIndicator

@Composable
fun Article(
    navController: NavController,
        )
{
    Article(
        navController = navController,
        scaffoldState = rememberScaffoldState(),
        )
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Article(
    registrationVM: RegistrationVM = hiltViewModel(),
    navController: NavController,
    scaffoldState: ScaffoldState,
        )
{
    Scaffold(
        modifier = Modifier
                .fillMaxSize(),
        scaffoldState = scaffoldState,
        snackbarHost = {
            SnackbarHostSho(hostState = scaffoldState.snackbarHostState)
        },
        topBar = { TopBarArticle(navController = navController) },
            )
    {
        Box( modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
           )
        {
            if(registrationVM.uiState.progressing)
            {
                CircleProgressIndicator()
            }
        }
    }
}