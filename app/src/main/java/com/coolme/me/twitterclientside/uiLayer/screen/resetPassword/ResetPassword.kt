package com.coolme.me.twitterclientside.uiLayer.screen.resetPassword

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.focusTarget
import androidx.compose.ui.input.pointer.pointerInput
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.coolme.me.twitterclientside.uiLayer.component.ErrorText
import com.coolme.me.twitterclientside.uiLayer.component.SnackbarHostSho
import com.coolme.me.twitterclientside.uiLayer.modifierExtention.shadowWithColor
import com.coolme.me.twitterclientside.uiLayer.theme.*
import com.coolme.me.twitterclientside.uiLayer.widget.CircleProgressIndicator
import com.coolme.me.twitterclientside.uiLayer.widget.resetPassword.PasswordForResetPassword
import com.coolme.me.twitterclientside.uiLayer.widget.resetPassword.ResetCodeForResetPassword
import com.coolme.me.twitterclientside.uiLayer.widget.resetPassword.UsernameForResetPassword

@Composable
fun ResetPassword(navController: NavController)
{
    val focusRequester by remember { mutableStateOf(FocusRequester()) }

    ResetPassword(
        navController = navController,
        focusRequester = focusRequester,
        scaffoldState = rememberScaffoldState(),
                  )
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ResetPassword(
    vM: ResetPasswordVM = hiltViewModel(),
    navController: NavController,
    focusRequester: FocusRequester,
    scaffoldState: ScaffoldState,
                  )
{
    Scaffold(
        modifier = Modifier
                .focusRequester(focusRequester)
                .focusTarget()
                .pointerInput(Unit) { detectTapGestures { focusRequester.requestFocus() } },
        scaffoldState = scaffoldState,
        snackbarHost = {
            SnackbarHostSho(hostState = scaffoldState.snackbarHostState)
        },
        topBar = { TopBarResetPassword(navController) },
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
                    UsernameForResetPassword(vM = vM)
                    ResetCodeForResetPassword(vM = vM)
                    PasswordForResetPassword(vM = vM, onSend = {})
                    ErrorText(errorMessage = "This is NOT valid Password",
                              hasError = vM.uiState.newPasswordHasError)
                    ResetButton(onClick = {vM.resetPassword(scaffoldState, navController)})
                }

                if(vM.uiState.progressing)
                {
                    CircleProgressIndicator()
                }
            }
        }
    }
}