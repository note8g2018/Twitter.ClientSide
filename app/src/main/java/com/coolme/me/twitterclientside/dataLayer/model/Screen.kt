package com.coolme.me.twitterclientside.dataLayer.model

sealed class Screen(val route: String)
{
    object Login : Screen(route = "login")
    object Registration : Screen(route = "registration")
    object Wall : Screen(route = "wall")
    object ForgetPassword : Screen(route = "forgetPassword")
    object ResetPassword : Screen(route = "resetPassword")
    object Home : Screen(route = "home")
    object Article : Screen(route = "article")
    object Profile : Screen(route = "profile")
}
