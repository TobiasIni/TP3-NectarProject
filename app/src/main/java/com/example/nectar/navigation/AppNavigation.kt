package com.example.nectar.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nectar.OnBoard
import com.example.nectar.SplashScreen
import com.example.nectar.singin.Login
import com.example.nectar.home.HomeScreen
import com.example.nectar.navigation.AppScreems.MainScreen


@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreems.SplashScreen.route) {
        composable(AppScreems.SplashScreen.route) {
            SplashScreen(navController)
        }
        composable(AppScreems.OnBoard.route) {
            OnBoard(navController)  // Aquí pasas el navController
        }


        composable(AppScreems.SignInScreen.route) {
            Login(navController)  // Esta es la pantalla de SignIn
        }
        composable(AppScreems.MainScreen.route) {
            Login(navController)

            composable(AppScreems.SignInScreen.route) {
                Login(navController)  // Esta es la pantalla de SignIn
            }
            composable(AppScreems.MainScreen.route) {
                Login(navController)

            }
            composable(AppScreems.SignInScreen.route) {
                MainScreen  // Esta es la pantalla de SignIn
            }
            composable(AppScreems.MainScreen.route) {
                MainScreen
            }
            composable(AppScreems.HomeScreen.route) {
                HomeScreen()
            }
        }
    }
}
