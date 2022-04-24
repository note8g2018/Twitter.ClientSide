package com.coolme.me.twitterclientside.uiLayer.screen.profile

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.coolme.me.twitterclientside.uiLayer.component.ButtonSho
import com.coolme.me.twitterclientside.uiLayer.component.ImageSho
import com.coolme.me.twitterclientside.uiLayer.component.SnackbarHostSho
import com.coolme.me.twitterclientside.uiLayer.component.TextFieldSho
import com.coolme.me.twitterclientside.uiLayer.theme.PaddingColumn
import com.coolme.me.twitterclientside.uiLayer.theme.SpaceColumnHeight
import com.coolme.me.twitterclientside.uiLayer.widget.CircleProgressIndicator

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ProfileEdit(
    navController: NavController,
           )
{
    val keyboardController = LocalSoftwareKeyboardController.current
    ProfileEdit(
        keyboardController = keyboardController,
        navController = navController,
        scaffoldState = rememberScaffoldState(),
           )
}

@OptIn(ExperimentalComposeUiApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ProfileEdit(
    keyboardController: SoftwareKeyboardController?,
    vM: ProfileVM = hiltViewModel(),
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
        topBar = { TopBarProfileEdit(navController = navController) },
            )
    {
        Box( modifier = Modifier
            .fillMaxSize()
            //.verticalScroll(rememberScrollState())
           )
        {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(PaddingColumn),
                verticalArrangement = Arrangement.spacedBy(space = SpaceColumnHeight),
                  )
            {
                TextFieldSho(
                    value = vM.userPhone.nickname,
                    onValueChange = {vM.onNicknameChange(it)},
                    label = "Nickname"
                            )

                ImageSho(navController)

                ButtonSho(
                    onClick = {
                        keyboardController?.hide()
                    },
                    text = "Save",
                         )
            }

            if(vM.uiState.progressing)
            {
                CircleProgressIndicator()
            }
        }
    }
}