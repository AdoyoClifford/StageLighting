package com.adoyo.stagelighting.presentation.main_screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.adoyo.stagelighting.data.Tab
import com.adoyo.stagelighting.presentation.main_screen.components.BottomBar
import com.adoyo.stagelighting.presentation.main_screen.components.TopBar

@Composable
fun MainScreen(navController: NavController) {
    Scaffold(
        topBar = { TopBar(navController) },
        bottomBar = {
            BottomBar(
                selectedTab = Tab.Home,
                onSelectedTab = {})
        }) { paddingValues: PaddingValues ->
        Text(text = "Text", modifier = Modifier.padding(paddingValues))
    }
}




