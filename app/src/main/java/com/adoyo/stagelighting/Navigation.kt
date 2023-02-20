package com.adoyo.stagelighting

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.adoyo.stagelighting.presentation.details_screen.DetailsScreen
import com.adoyo.stagelighting.presentation.main_screen.MainScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.HomeScreen.route) {
        composable(Screens.HomeScreen.route) {
            MainScreen(navController = navController)
        }

        composable(Screens.DetailScreen.route + "/{productId}") {
            DetailsScreen()
        }

    }
}