package com.example.nectar.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nectar.OnBoard
import com.example.nectar.SplashScreen
import com.example.nectar.detail.DetailScreen
import com.example.nectar.singin.Login
import com.example.nectar.home.HomeScreen


@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AppScreems.SplashScreen.route) {
        composable(AppScreems.SplashScreen.route) {
            SplashScreen(navController)
        }
        composable(AppScreems.OnBoard.route) {
            OnBoard(navController)
        }
        composable(AppScreems.SignInScreen.route) {
            Login(navController)
        }
        composable(AppScreems.HomeScreen.route) {
            HomeScreen(navController)
        }
        composable(AppScreems.DetailsScreen.route) {
            DetailScreen(navController)  // Asegúrate de que DetailScreen reciba navController
        }
    }
}
