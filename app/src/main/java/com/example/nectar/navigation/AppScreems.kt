package com.example.nectar.navigation


sealed class AppScreems(val route: String) {
    object SplashScreen : AppScreems("splash_screen")
    object OnBoard : AppScreems("onboard_screen")
    object SignInScreen : AppScreems("signin_screen")
    object MainScreen : AppScreems("main_screen")
}
