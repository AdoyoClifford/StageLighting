package com.adoyo.stagelighting.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.adoyo.stagelighting.data.Tab

@Composable
fun MainScreen() {
    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomBar(selectedTab = Tab.Home, onSelectedTab = {}) }) {paddingValues: PaddingValues ->
        Text(text = "Text", modifier = Modifier.padding(paddingValues))
    }

}

@Composable
fun TopBar() {
    val viewModel = viewModel<MainViewModel>()
    val searchText by viewModel.searchText.collectAsState()
    val items by viewModel.persons.collectAsState()
    val isSearching by viewModel.isSearching.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TextField(
            value = searchText,
            onValueChange = viewModel::onSearchTextChange,
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "Search") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        if (isSearching) {
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                items(items) { item ->
                    Text(
                        text = "${item.name} ",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 16.dp)
                    )
                }
            }
        }
    }
}


@Composable
fun BottomBar(
    selectedTab: Tab,
    onSelectedTab: (Tab) -> Unit
) {
    BottomNavigation(
        backgroundColor = Color.White,
        elevation = 8.dp
    ) {
        BottomNavigationItem(
            icon = { Icon(Icons.Filled.Home,contentDescription = null) },
            label = { Text(text = "Home") },
            selected = selectedTab == Tab.Home,
            onClick = { onSelectedTab(Tab.Home) })

        BottomNavigationItem(
            icon = { Icon(Icons.Filled.Add,contentDescription = null) },
            label = { Text(text = "Add") },
            selected = selectedTab == Tab.Add,
            onClick = { onSelectedTab(Tab.Add) })

        BottomNavigationItem(
            icon = { Icon(Icons.Filled.Chat,contentDescription = null) },
            label = { Text(text = "Chat") },
            selected = selectedTab == Tab.Chat,
            onClick = { onSelectedTab(Tab.Chat) })

        BottomNavigationItem(
            icon = { Icon(Icons.Filled.Person,contentDescription = null) },
            label = { Text(text = "profile") },
            selected = selectedTab == Tab.Profile,
            onClick = { onSelectedTab(Tab.Profile) })
    }

}