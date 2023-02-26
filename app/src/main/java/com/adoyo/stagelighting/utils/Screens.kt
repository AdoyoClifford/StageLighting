package com.adoyo.stagelighting.utils

sealed class Screens(val route: String) {
    object MainScreen : Screens("main_screen")
    object DetailScreen : Screens("detail_screen")
    object CheckoutScreen: Screens("checkout_screen")
    object SignInScreen: Screens("sign_in_screen")
    object SignUpScreen: Screens("sign_up_screen")
    object SplashScreen: Screens("splash_screen")

}