package com.adoyo.stagelighting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.adoyo.stagelighting.presentation.auth.login.LogIn
import com.adoyo.stagelighting.presentation.details_screen.DetailsScreen
import com.adoyo.stagelighting.presentation.main_screen.MainScreen
import com.adoyo.stagelighting.ui.theme.StageLightingTheme
import com.adoyo.stagelighting.utils.Screens
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StageLightingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                   // Navigation()
                    LogIn()
                }
            }
        }
    }
}















