package com.adoyo.stagelighting.presentation.details_screen

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.adoyo.stagelighting.data.Tab
import com.adoyo.stagelighting.presentation.details_screen.components.DetailsBottomBar
import com.adoyo.stagelighting.presentation.details_screen.components.DetailsItem
import com.adoyo.stagelighting.presentation.details_screen.components.DetailsTopBar

@Composable
fun DetailsScreen() {
    val viewModel = viewModel<DetailsViewModel>()
    val details by viewModel.items.collectAsState()
    Scaffold(topBar = { DetailsTopBar(onBack = {}) }, bottomBar = {
        DetailsBottomBar(
            selectedTab = Tab.Add,
            onSelectedTab = {}
        )
    }) { paddingValues ->
        LazyColumn() {
            items(details) {
                DetailsItem(details = it)
            }
        }
        Text(text = "Hello", modifier = Modifier.padding(paddingValues))

    }
}




