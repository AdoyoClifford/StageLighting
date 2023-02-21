package com.adoyo.stagelighting

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.adoyo.stagelighting.presentation.details_screen.DetailsScreen
import com.adoyo.stagelighting.presentation.main_screen.MainScreen
import com.adoyo.stagelighting.utils.Screens

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screens.MainScreen.route
    ) {
        composable(Screens.MainScreen.route) {
            MainScreen(navController)
        }
        composable(
            "${Screens.DetailScreen.route}/{itemId}",
            arguments = listOf(navArgument("itemId") { type = NavType.IntType })
        ) { backStackEntry ->
            backStackEntry.arguments?.getInt("itemId")?.let { itemId ->
                DetailsScreen(itemId)
            }

        }
    }
}