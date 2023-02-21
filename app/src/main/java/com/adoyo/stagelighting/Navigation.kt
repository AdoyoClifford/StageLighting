package com.adoyo.stagelighting

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.adoyo.stagelighting.feature_product.presentation.details.DataDetailsScreen
import com.adoyo.stagelighting.feature_product.presentation.items.ItemsScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.ItemsScreen.route) {
        composable(Screens.ItemsScreen.route) {
            ItemsScreen(navController = navController)
        }

        composable(Screens.DataDetailsScreen.route + "/{itemId}") {
            DataDetailsScreen()
        }

    }
}