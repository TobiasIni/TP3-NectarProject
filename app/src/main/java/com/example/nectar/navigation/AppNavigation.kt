package com.example.nectar.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nectar.OnBoard
import com.example.nectar.SplashScreem.SplashScreen
import com.example.nectar.account.AccountScreen
import com.example.nectar.cart.CartScreen
import com.example.nectar.detail.DetailScreen
import com.example.nectar.explore.Explore
import com.example.nectar.favorite.ProductScreen
import com.example.nectar.filter.FilterScreen
import com.example.nectar.singin.Login
import com.example.nectar.home.HomeScreen
import com.example.nectar.location.LocationScreen
import com.example.nectar.signup.SignUp

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
            DetailScreen(navController)
        }
        composable(AppScreems.selectLocationScreen.route) {
            LocationScreen(navController)
        }
        composable(AppScreems.CartScreen.route) {
            CartScreen(navController) // Aquí pasamos navController
        }
        composable(AppScreems.FavoriteScreen.route) {
            ProductScreen(navController)
        }
        composable(AppScreems.ExploreScreen.route) {
            Explore(navController)
        }
        composable(AppScreems.SignUp.route) {
            SignUp(navController)
        }
        composable(AppScreems.AccountScreen.route){
            AccountScreen(navController)
        }
        composable(AppScreems.FavoriteScreen.route){
            ProductScreen(navController)
        }
        composable(AppScreems.Filter.route){
            FilterScreen(navController)
        }
    }
}
