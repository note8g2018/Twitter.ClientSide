package com.coolme.me.twitterclientside

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.coolme.me.twitterclientside.uiLayer.theme.TwitterClientSideTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity()
{
    private val navHostShoVM : NavHostShoVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?)
    {
        installSplashScreen().setKeepOnScreenCondition {
            navHostShoVM.isLoading
        }
        super.onCreate(savedInstanceState)

        setContent {
            TwitterClientSideTheme(darkTheme = true)
            {
                NavHostSho()
            }
        }
    }
}






