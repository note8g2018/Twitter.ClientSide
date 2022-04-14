package com.coolme.me.twitterclientside.uiLayer.screen.registration

import android.annotation.SuppressLint
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.LayoutCoordinates
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.coolme.me.twitterclientside.uiLayer.component.SnackbarHostSho
import com.coolme.me.twitterclientside.uiLayer.widget.CircleProgressIndicator
import com.coolme.me.twitterclientside.uiLayer.widget.Email
import com.coolme.me.twitterclientside.uiLayer.widget.registration.Password
import com.coolme.me.twitterclientside.uiLayer.widget.registration.Username

@Composable
fun Registration(navController: NavController)
{
    var screenWidth : Int by remember { mutableStateOf(0) }

    Registration(
        navController = navController,
        scaffoldState = rememberScaffoldState(),
        screenWidth = screenWidth,
        onScreenWidthChange = {
            screenWidth = it.size.width + 100
        },
                )
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Registration(
    registrationVM: RegistrationVM = hiltViewModel(),
    navController: NavController,
    scaffoldState: ScaffoldState,
    screenWidth : Int,
    onScreenWidthChange: (LayoutCoordinates) -> Unit,
                )
{
    var xOffsetState : Dp by remember { mutableStateOf(0.dp) }
    val xOffset : Dp by animateDpAsState(
        targetValue = xOffsetState,
        animationSpec = tween(
            durationMillis = 2000,
            easing = LinearEasing,
                             ),
                                        )
    Scaffold(
        modifier = Modifier
                .fillMaxSize()
                .onGloballyPositioned {
                    onScreenWidthChange(it)
                },
        scaffoldState = scaffoldState,
        snackbarHost = {
            SnackbarHostSho(hostState = scaffoldState.snackbarHostState)
        },
        topBar = { TopBarRegistration(navController = navController) },
            )
    {
        Box( modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
           )
        {
            Username(
                registrationVM= registrationVM,
                xOffset = xOffset,
                onUsernameNext = {xOffsetState = Dp(-0.35f * screenWidth.toFloat())},
                    )
            Email(
                registrationVM= registrationVM,
                xOffset = xOffset + Dp(0.35f * screenWidth.toFloat()),
                onEmailNext = {xOffsetState = Dp(-0.35f * 2 * screenWidth.toFloat())},
                onBack = { xOffsetState = 0.dp},
                 )
            Password(
                registrationVM= registrationVM,
                xOffset = xOffset + Dp(0.35f * 2 * screenWidth.toFloat()),

                onBack = {
                    xOffsetState = Dp(-0.35f * screenWidth.toFloat())
                    registrationVM.onBackFromPassword()
                         },
                onPasswordNext = {
                    registrationVM.send(scaffoldState, navController)
                },
                    )

            if(registrationVM.uiState.progressing)
            {
                CircleProgressIndicator()
            }
        }
    }
}