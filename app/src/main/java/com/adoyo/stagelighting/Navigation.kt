package com.adoyo.stagelighting

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.adoyo.stagelighting.presentation.auth.presentation.login.SignInScreen
import com.adoyo.stagelighting.presentation.auth.presentation.signup.SignUpScreen
import com.adoyo.stagelighting.presentation.cart.CartViewModel
import com.adoyo.stagelighting.presentation.details_screen.DetailsScreen
import com.adoyo.stagelighting.presentation.main_screen.MainScreen
import com.adoyo.stagelighting.utils.Screens

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val cartViewModel = viewModel<CartViewModel>()
    NavHost(
        navController = navController,
        startDestination = Screens.SignUpScreen.route
    ) {
        composable( Screens.SignUpScreen.route) {
            SignUpScreen(navController)
        }
        composable( Screens.SignInScreen.route) {
            SignInScreen()
        }

        composable(Screens.MainScreen.route) {
            MainScreen(navController)
        }
        composable(
            "${Screens.DetailScreen.route}/{itemId}",
            arguments = listOf(navArgument("itemId") { type = NavType.IntType })
        ) { backStackEntry ->
            backStackEntry.arguments?.getInt("itemId")?.let { itemId ->
                DetailsScreen(navController,itemId)
            }
        }
    }
}