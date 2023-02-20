package com.adoyo.stagelighting.presentation.details_screen.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.adoyo.stagelighting.data.Tab

@Composable
fun DetailsBottomBar(
    selectedTab: Tab,
    onSelectedTab: (Tab) -> Unit
) {
    BottomNavigation(
        backgroundColor = Color.White,
        elevation = 8.dp
    ) {
        BottomNavigationItem(
            icon = { Icon(Icons.Filled.Home, contentDescription = null) },
            label = { Text(text = "Home") },
            selected = selectedTab == Tab.Home,
            onClick = { onSelectedTab(Tab.Home) })

        BottomNavigationItem(
            icon = { Icon(Icons.Filled.Add, contentDescription = null) },
            label = { Text(text = "Add") },
            selected = selectedTab == Tab.Add,
            onClick = { onSelectedTab(Tab.Add) })

        BottomNavigationItem(
            icon = { Icon(Icons.Filled.Chat, contentDescription = null) },
            label = { Text(text = "Chat") },
            selected = selectedTab == Tab.Chat,
            onClick = { onSelectedTab(Tab.Chat) })

        BottomNavigationItem(
            icon = { Icon(Icons.Filled.Person, contentDescription = null) },
            label = { Text(text = "profile") },
            selected = selectedTab == Tab.Profile,
            onClick = { onSelectedTab(Tab.Profile) })
    }
}