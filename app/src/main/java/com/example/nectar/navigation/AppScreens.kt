package com.example.nectar.navigation


sealed class AppScreens(val route: String) {
    object SplashScreen : AppScreens("splash_screen")
    object OnBoard : AppScreens("onboard_screen")
    object SignInScreen : AppScreens("signin_screen")
    object MainScreen : AppScreens("main_screen")
    object HomeScreen : AppScreens("home_screen")
}
