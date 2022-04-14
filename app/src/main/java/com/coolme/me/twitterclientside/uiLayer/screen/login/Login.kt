package com.coolme.me.twitterclientside.uiLayer.screen.login

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import com.coolme.me.twitterclientside.dataLayer.model.Screen
import com.coolme.me.twitterclientside.uiLayer.component.SnackbarHostSho
import com.coolme.me.twitterclientside.uiLayer.modifierExtention.shadowWithColor
import com.coolme.me.twitterclientside.uiLayer.theme.*
import com.coolme.me.twitterclientside.uiLayer.widget.CircleProgressIndicator
import com.coolme.me.twitterclientside.uiLayer.widget.login.PasswordForLogin
import com.coolme.me.twitterclientside.uiLayer.widget.login.UsernameForLogin

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Login(navController: NavController)
{
    val keyboardController = LocalSoftwareKeyboardController.current
    Login(
        keyboardController = keyboardController,
        navController = navController,
        scaffoldState = rememberScaffoldState(),
        onRegistration = {
            keyboardController?.hide()
            navController.navigate(Screen.Registration.route)
                         },
        onForgetPassword = {navController.navigate(Screen.ForgetPassword.route)},
         )
}

@OptIn(ExperimentalComposeUiApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Login(
    keyboardController: SoftwareKeyboardController?,
    vM: LoginVM = hiltViewModel(),
    navController: NavController,
    scaffoldState: ScaffoldState,
    onRegistration: ()-> Unit,
    onForgetPassword: ()-> Unit,
         )
{

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState,
        snackbarHost = {
            SnackbarHostSho(hostState = scaffoldState.snackbarHostState)
        },
        topBar = { TopBarLogin() },
            )
    {
        Column(
            modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
              )
        {
            Box(
                modifier = Modifier
                        .padding(PaddingAll)
                        .fillMaxWidth()
                        .shadowWithColor(
                            color = TopBarContent,
                            shadowRadius = ShadowRadius,
                                        )
                        .background(color = BoxBackground)
               )
            {
                Column(
                    modifier = Modifier
                            .padding(PaddingColumn)
                            .fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(space = SpaceColumnHeight),
                      )
                {
                    UsernameForLogin(vM = vM)
                    PasswordForLogin(vM= vM, onSend = {})
                    LoginButton(onClick = {
                        keyboardController?.hide()
                        vM.login(scaffoldState, navController)
                    })
                    RegistrationButton(onClick = onRegistration)
                }

                if(vM.uiState.progressing)
                {
                    CircleProgressIndicator()
                }
            }

            Spacer(modifier = Modifier.weight(weight = 1.0f, fill = true))
            ForgetPasswordButton(onClick = onForgetPassword)
        }
    }
}