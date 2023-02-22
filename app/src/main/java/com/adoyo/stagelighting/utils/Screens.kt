package com.adoyo.stagelighting.utils

sealed class Screens(val route: String) {
    object MainScreen : Screens("main_screen")
    object DetailScreen : Screens("detail_screen")
    object CheckoutScreen: Screens("checkout_screen")
    object SignInScreen: Screens("sign_in_screen")
    object SignUpScreen: Screens("sign_up_screen")

//    fun navigate(navController: NavHostController, arg: Any? = null) {
//        val route = if (arg != null) "$route/$arg" else route
//        navController.navigate(route)
//    }
}