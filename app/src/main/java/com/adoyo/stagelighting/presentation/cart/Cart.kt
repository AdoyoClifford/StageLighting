package com.adoyo.stagelighting.presentation.cart

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.RemoveCircleOutline
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.adoyo.stagelighting.data.Category
import com.adoyo.stagelighting.data.Item

@Composable
fun Cart(count: Int) {
    Box(
        modifier = Modifier
            .size(36.dp)
            .clickable(onClick = { /* TODO */ })
    ) {
        Icon(
            imageVector = Icons.Filled.ShoppingCart,
            contentDescription = "Cart",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
        if (count > 0) {
            Text(
                text = count.toString(),
                color = Color.White,
                fontSize = MaterialTheme.typography.caption.fontSize,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .background(Color.Red)
                    .padding(2.dp)
                    .clip(CircleShape)
                    .align(Alignment.TopEnd)
            )
        }
    }
}