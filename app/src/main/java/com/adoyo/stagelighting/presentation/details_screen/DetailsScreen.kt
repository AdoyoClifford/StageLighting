package com.adoyo.stagelighting.presentation.details_screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.adoyo.stagelighting.presentation.details_screen.components.DetailsBottomBar
import com.adoyo.stagelighting.presentation.details_screen.components.DetailsItem
import com.adoyo.stagelighting.presentation.details_screen.components.DetailsTopBar

@Composable
fun DetailsScreen(navController: NavController,ItemId: Int) {
  //  val item = allItems.find { it.id == ItemId }
    Scaffold(topBar = { DetailsTopBar(navController)}, bottomBar = { DetailsBottomBar(ItemId = ItemId)}) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            Spacer(modifier = Modifier.padding(paddingValues))
            DetailsItem(ItemId =ItemId)


        }

    }
}


