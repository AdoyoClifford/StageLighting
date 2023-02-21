package com.adoyo.stagelighting

sealed class Screens(val route: String) {
    object SplashScreen: Screens("splash")
    object ItemsScreen: Screens("items")
    object DataDetailsScreen: Screens("data")
    object SignInScreen: Screens("login")
    object SignUpScreen: Screens("sign_in")
    object HomeScreen: Screens("home")
    object ProfileScreen: Screens("profile")
    object DetailScreen: Screens("detail")
    object Test: Screens("test")
}