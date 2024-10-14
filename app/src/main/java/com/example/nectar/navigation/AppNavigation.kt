package com.example.nectar.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nectar.OnBoard
import com.example.nectar.SplashScreen
import com.example.nectar.singin.Login
import com.example.nectar.home.HomeScreen
import com.example.nectar.singin.MainScreen


@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.SplashScreen.route) {
        composable(AppScreens.SplashScreen.route) {
            SplashScreen(navController)
        }
        composable(AppScreens.OnBoard.route) {
            OnBoard(navController)  // Aquí pasas el navController
        }
<<<<<<< Updated upstream

        composable(AppScreens.SignInScreen.route) {
            Login()  // Esta es la pantalla de SignIn
        }
        composable(AppScreens.MainScreen.route) {
            Login()
=======
        composable(AppScreems.SignInScreen.route) {
            Login(navController)  // Esta es la pantalla de SignIn
        }
        composable(AppScreems.MainScreen.route) {
            Login(navController)
>>>>>>> Stashed changes
        }
        composable(AppScreens.SignInScreen.route) {
            MainScreen()  // Esta es la pantalla de SignIn
        }
        composable(AppScreens.MainScreen.route) {
            MainScreen()
        }
        composable(AppScreens.HomeScreen.route){
            HomeScreen()
        }
    }
}
