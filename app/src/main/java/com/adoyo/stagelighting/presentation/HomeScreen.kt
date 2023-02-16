package com.adoyo.stagelighting.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun HomeScreen() {
    // create a scaffold with a top app bar and bottom bar
    Scaffold(
        topBar = {
            TopAppBar()
        }
    ) { padding ->
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = "Hello World", modifier = Modifier.padding(padding))
        }
    }

}

@Composable
fun TopAppBar() {
    val viewModel = viewModel<MainViewModel>()
    val searchText by viewModel.searchText.collectAsState()
    val products by viewModel.products.collectAsState()
    val isSearching by viewModel.isSearching.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 42.dp)
    ) {

        Text(text = "Hello")
        TextField(
            value = searchText,
            onValueChange = viewModel::onSearchTextChange,
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "Search") },
            leadingIcon = { Icon(Icons.Rounded.Search, contentDescription = "Search") },
            trailingIcon = {
                if (searchText.isNotBlank()) {
                    Icon(
                        Icons.Rounded.Clear,
                        contentDescription = "Clear search",
                        modifier = Modifier.clickable {
                            viewModel.onSearchTextChange("")
                        }
                    )
                }
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        if (isSearching) {
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        } else {
            LazyVerticalGrid(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f), columns = GridCells.Fixed(2), contentPadding = PaddingValues(
                    start = 16.dp,
                    end = 16.dp,
                    ),content =  {
                    items(products.size) { items ->
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(products[items].image)
                                .crossfade(true)
                                .build(),
                            //placeholder = painterResource(R.drawable.placeholder),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                          //  modifier = Modifier.clip(CircleShape)
                        )
                    }
                })
        }
    }
}

@Composable
fun ProductCard() {
    val viewModel = viewModel<MainViewModel>()


}


@Composable
fun BottomBar() {

}