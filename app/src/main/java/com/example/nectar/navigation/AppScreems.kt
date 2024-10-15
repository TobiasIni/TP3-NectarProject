package com.example.nectar.navigation


sealed class AppScreems(val route: String) {
    object SplashScreen : AppScreems("splash_screen")
    object OnBoard : AppScreems("onboard_screen")
    object SignInScreen : AppScreems("signin_screen")
    object MainScreen : AppScreems("main_screen")
    object AccountScreen : AppScreems("account_screen")
    object CartScreen : AppScreems("cart_screen")
    object HomeScreen : AppScreems("home_screen")
    object DetailsScreen : AppScreems("details_screen")
    object SignUp : AppScreems("signup_screen")
    object selectLocationScreen : AppScreems("selectLocation_screen")
}
