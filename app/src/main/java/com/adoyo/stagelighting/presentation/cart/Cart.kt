package com.adoyo.stagelighting.presentation.cart

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.RemoveCircleOutline
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.adoyo.stagelighting.data.Category
import com.adoyo.stagelighting.data.Item

@Composable
fun CartScreen(viewModel: CartViewModel) {
    val items by viewModel.items.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "My Cart",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )

        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(items) { item ->
                CartItem(
                    item = item,
                    onRemove = { viewModel.removeItem(item) }
                )
            }
        }

        Text(
            text = "Total: $${viewModel.total}",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier.padding(16.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = { viewModel.clear() },
                modifier = Modifier.padding(16.dp)
            ) {
                Text(text = "Clear Cart")
            }

            Button(
                onClick = { viewModel.addItem(Item(1, "Example Item", Category.AUDIO, 9.99, "https://example.com/item.jpg", description = ""), 1) },
                modifier = Modifier.padding(16.dp)
            ) {
                Text(text = "Add Example Item")
            }
        }
    }
}

@Composable
fun CartItem(item: CartStateItem, onRemove: () -> Unit) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Image(
            painter = rememberAsyncImagePainter(item.item.image),
            contentDescription = item.item.name,
            modifier = Modifier
                .size(64.dp)
                .padding(8.dp)
        )

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = item.item.name,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )

            Text(
                text = "${item.quantity} x $${item.item.price}",
                fontSize = 14.sp,
                color = Color.Gray
            )
        }

        IconButton(onClick = onRemove) {
            Icon(Icons.Filled.RemoveCircleOutline, contentDescription = "Remove Item")
        }
    }
}