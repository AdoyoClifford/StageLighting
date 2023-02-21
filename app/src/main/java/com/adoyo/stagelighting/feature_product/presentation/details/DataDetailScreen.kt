package com.adoyo.stagelighting.feature_product.presentation.details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun DataDetailsScreen(viewModel: DetailsViewModel = hiltViewModel()) {
    val state = viewModel.state.value

    Box(modifier = Modifier.fillMaxSize()) {
        //Text(text = "Hello")
        state.details?.let { details ->
            LazyColumn() {
                item {
                    DetailsItem(details = details)
                }

                item {
                    Text(text = details.description)
                }
            }
        }
    }
}