package com.adoyo.stagelighting.presentation.details_screen.components

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.adoyo.stagelighting.data.allItems
import com.adoyo.stagelighting.presentation.cart.Cart
import com.adoyo.stagelighting.presentation.cart.CartViewModel

@Composable
fun DetailsBottomBar(ItemId: Int,viewModel: CartViewModel) {
    val cartCount by viewModel.cartCountItems.collectAsState()
    val context = LocalContext.current
    val item = allItems.find { it.id == ItemId }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "$ ${item?.price}",
            style = TextStyle(fontSize = MaterialTheme.typography.h4.fontSize),
            modifier = Modifier.weight(1f)
        )
        TextButton(
            onClick = {
                viewModel.increment()
                Toast.makeText(context,"${item?.name} added to cart",Toast.LENGTH_SHORT).show()
            }, modifier = Modifier
                .clip(
                    RoundedCornerShape(18.dp)
                )
                .background(Color.Black)
        ) {
            Text(
                text = "Add to cart",
                style = TextStyle(fontWeight = FontWeight.Bold),
                fontSize = MaterialTheme.typography.h4.fontSize
            )

        }
        Icon(
            imageVector = Icons.Filled.ShoppingCart,
            contentDescription = "Cart",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
        if (cartCount > 0) {
            Text(
                text = cartCount.toString(),
                color = Color.White,
                fontSize = MaterialTheme.typography.caption.fontSize,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .background(Color.Red)
                    .padding(2.dp)
                    .clip(CircleShape)
                // .align(Alignment.TopEnd)
            )
        }
    }
}