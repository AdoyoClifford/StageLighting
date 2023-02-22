package com.adoyo.stagelighting.presentation.main_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.adoyo.stagelighting.presentation.main_screen.MainViewModel
import com.adoyo.stagelighting.ui.theme.AweSomeGrey
import com.adoyo.stagelighting.ui.theme.AwesomeWhite
import com.adoyo.stagelighting.utils.Screens

@Composable
fun TopBar(navController: NavController) {
    val viewModel = viewModel<MainViewModel>()
    val searchText by viewModel.searchText.collectAsState()
    val items by viewModel.items.collectAsState()
    val isSearching by viewModel.isSearching.collectAsState()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(AwesomeWhite), contentAlignment = Alignment.Center
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            OutlinedTextField(
                value = searchText,
                onValueChange = viewModel::onSearchTextChange,
                modifier = Modifier.fillMaxWidth().background(AweSomeGrey),
                placeholder = { Text(text = "Search") },
                singleLine = true,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search"
                    )
                },
                trailingIcon = {
                    if (searchText.isNotEmpty()) {
                        IconButton(onClick = { viewModel.onSearchTextChange("") }) {
                            Icon(
                                imageVector = Icons.Default.Clear,
                                contentDescription = "Clear search"
                            )
                        }
                    }
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = MaterialTheme.colors.primary,
                    unfocusedBorderColor = MaterialTheme.colors.primary
                ),

                )
            Spacer(modifier = Modifier.height(16.dp))
            if (isSearching) {
                Box(modifier = Modifier.fillMaxSize()) {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            } else {
                LazyVerticalGrid(columns = GridCells.Fixed(2), modifier = Modifier.background(
                    AwesomeWhite)) {
                    items(items) { item ->
                        ItemCard(item = item, onClick = {
                            navController.navigate(Screens.DetailScreen.route + "/${item.id}")
                        })
                    }
                }
            }
        }
    }
}
