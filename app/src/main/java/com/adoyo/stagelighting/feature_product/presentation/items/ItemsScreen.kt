package com.adoyo.stagelighting.feature_product.presentation.items

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.adoyo.stagelighting.Screens

@Composable
fun ItemsScreen(viewModel: ItemsViewModel = hiltViewModel(), navController: NavController) {
    val state = viewModel.state.value


    Box(modifier = Modifier.fillMaxSize()) {
        LazyVerticalGrid(columns = GridCells.Fixed(2)) {
            items(state.items) { item ->
                StageItem(item = item, onItemClick = {
                    navController.navigate(Screens.DataDetailsScreen.route + "/${item.id}")
                })
            }
        }
    }
}