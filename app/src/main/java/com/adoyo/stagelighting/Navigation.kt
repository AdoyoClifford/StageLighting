package com.adoyo.stagelighting

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.adoyo.auth.presentation.SignInScreen
import com.adoyo.auth.presentation.SignUpScreen
import com.adoyo.auth.presentation.SplashScreen
import com.adoyo.stagelighting.presentation.cart.CartViewModel
import com.adoyo.stagelighting.presentation.details_screen.DetailsScreen
import com.adoyo.stagelighting.presentation.main_screen.MainScreen
import com.adoyo.stagelighting.utils.Screens
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

@Composable
fun Navigation() {

    val auth by lazy {
        Firebase.auth
    }
    val navController = rememberNavController()
    val cartViewModel = viewModel<CartViewModel>()

    NavHost(
        navController = navController,
        startDestination = Screens.SplashScreen.route
    ) {
        composable(Screens.SplashScreen.route) {
            SplashScreen(navController = navController)
        }
        composable(Screens.SignInScreen.route) {
            SignInScreen(
                auth = auth,
                navController
            ) { }
        }

        composable(Screens.SignUpScreen.route) {
            SignUpScreen(navController,auth) {}
        }

        composable(Screens.MainScreen.route) {
            MainScreen(navController)
        }
        composable(
            "${Screens.DetailScreen.route}/{itemId}",
            arguments = listOf(navArgument("itemId") { type = NavType.IntType })
        ) { backStackEntry ->
            backStackEntry.arguments?.getInt("itemId")?.let { itemId ->
                DetailsScreen(navController, itemId)
            }
        }
    }
}