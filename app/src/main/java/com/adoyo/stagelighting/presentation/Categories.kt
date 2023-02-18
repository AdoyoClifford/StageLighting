package com.adoyo.stagelighting.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.adoyo.stagelighting.Category
import com.adoyo.stagelighting.Item
import com.adoyo.stagelighting.R

@Composable
fun TopBar(onSearchTextChanged: (String) -> Unit) {
    var searchQuery by remember { mutableStateOf("") }

    Column(Modifier.background(color = MaterialTheme.colors.primary)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "My App Name",
                style = MaterialTheme.typography.h6,
                color = Color.White
            )

            TextField(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .padding(start = 8.dp, end = 8.dp),
                value = searchQuery,
                onValueChange = {
                    searchQuery = it
                    onSearchTextChanged(it)
                },
                placeholder = { Text("Search") },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    textColor = MaterialTheme.colors.onSurface
                )
            )
        }

        Divider(
            color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f),
            thickness = 1.dp,
        )
    }
}
@Composable
fun BottomBar(
    tabs: List<Tab>,
    currentTab: Tab,
    onTabSelected: (Tab) -> Unit,
) {
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.surface,
        contentColor = Color.Black
    ) {
        tabs.forEach { tab ->
            BottomNavigationItem(
                icon = { Icon(tab.icon, contentDescription = tab.title) },
                label = { Text(tab.title) },
                selected = currentTab == tab,
                onClick = { onTabSelected(tab) },
                selectedContentColor = MaterialTheme.colors.primary,
                unselectedContentColor = Color.Black,
                alwaysShowLabel = false,
            )
        }
    }
}

@Composable
fun ItemCard(item: Item, modifier: Modifier, onItemClick: (Item) -> Unit) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp,
        modifier = Modifier
            .padding(16.dp)
            .clickable(onClick = { onItemClick(item) })
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data({ item.image })
                    .crossfade(true)
                    .build(),
                // placeholder = painterResource(R.drawable.placeholder),
                contentDescription = stringResource(R.string.description),
                contentScale = ContentScale.Crop,
                modifier = Modifier.clip(CircleShape)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = item.name,
                style = MaterialTheme.typography.h6
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "$${item.price}",
                style = MaterialTheme.typography.body1,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun ItemRow(items: List<Item>) {
    LazyRow(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)) {
        items(items) { item ->
            ItemCard(item = item, modifier = Modifier.padding(end = 8.dp)) { item ->

            }
        }
    }
}


@Composable
fun CategoryCard(
    category: Category,
    isSelected: Boolean,
    modifier: Modifier,
    onCategoryClick: (Category) -> Unit
) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .background(
                if (isSelected) MaterialTheme.colors.primary
                else MaterialTheme.colors.surface
            )
            .clickable(onClick = { onCategoryClick(category) })
    ) {
        Text(
            text = category.label,
            style = MaterialTheme.typography.subtitle1,
            color = if (isSelected) MaterialTheme.colors.onPrimary
            else MaterialTheme.colors.onSurface,
            modifier = Modifier.padding(16.dp)
        )
    }
}

data class Tab(val title: String, val icon: ImageVector)

@Composable
fun CategoryRow(categories: List<Category>) {
    LazyRow(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)) {
        items(categories) { category ->
            CategoryCard(
                category = category,
                modifier = Modifier.padding(end = 8.dp),
                isSelected = true
            ) {

            }
        }
    }
}





