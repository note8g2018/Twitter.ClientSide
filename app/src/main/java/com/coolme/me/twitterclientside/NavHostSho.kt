package com.coolme.me.twitterclientside

import androidx.compose.foundation.focusable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.coolme.me.twitterclientside.dataLayer.model.Screen
import com.coolme.me.twitterclientside.uiLayer.camera.MainContent
import com.coolme.me.twitterclientside.uiLayer.screen.article.Article
import com.coolme.me.twitterclientside.uiLayer.screen.forgetPassword.ForgetPassword
import com.coolme.me.twitterclientside.uiLayer.screen.home.Home
import com.coolme.me.twitterclientside.uiLayer.screen.login.Login
import com.coolme.me.twitterclientside.uiLayer.screen.profile.Profile
import com.coolme.me.twitterclientside.uiLayer.screen.profile.ProfileEdit
import com.coolme.me.twitterclientside.uiLayer.screen.registration.Registration
import com.coolme.me.twitterclientside.uiLayer.screen.resetPassword.ResetPassword
import com.coolme.me.twitterclientside.uiLayer.screen.wall.Wall
import com.google.accompanist.permissions.ExperimentalPermissionsApi

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun NavHostSho(vM: NavHostShoVM = hiltViewModel())
{
    val navController = rememberNavController()
    //val focusRequester by remember { mutableStateOf(FocusRequester()) }
    val focusRequester = FocusRequester()
    val localFocusManager = LocalFocusManager.current

    NavHost(
        navController = navController,
        startDestination = vM.startDestination,
        modifier = Modifier
                .focusRequester(focusRequester)
                .focusable()
                .pointerInput(Unit) {
                    detectTapGestures(
                        onTap = {
                            //focusRequester.requestFocus()
                            localFocusManager.clearFocus()
                        }
                                     )
                }
                .fillMaxSize()
           )
    {
        composable(route= Screen.Login.route) { Login(navController = navController) }
        composable(route= Screen.Registration.route) { Registration(navController = navController) }
        composable(route= Screen.Wall.route) { Wall(navController = navController) }
        composable(route= Screen.ForgetPassword.route) { ForgetPassword(navController = navController) }
        composable(route= Screen.ResetPassword.route) { ResetPassword(navController = navController) }
        composable(route= Screen.Home.route) { Home(navController = navController) }
        composable(route= Screen.Article.route) { Article(navController = navController) }
        composable(route= Screen.Profile.route) { Profile(navController = navController) }
        composable(route= Screen.ProfileEdit.route) { ProfileEdit(navController = navController) }
        composable(route= Screen.MainContent.route) { MainContent() }
    }
}