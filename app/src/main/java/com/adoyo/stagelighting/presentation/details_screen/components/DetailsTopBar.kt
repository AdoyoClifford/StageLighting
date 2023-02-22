package com.adoyo.stagelighting.presentation.details_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.adoyo.stagelighting.presentation.cart.CartViewModel
import com.adoyo.stagelighting.ui.theme.AweSomeGrey

@Composable
fun DetailsTopBar(navController: NavController, viewModel: CartViewModel) {
    val cartCount by viewModel.cartCountItems.collectAsState()
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .clip(RoundedCornerShape(4.dp))
                .background(AweSomeGrey)
        ) {
            Icon(Icons.Filled.ChevronLeft, contentDescription = "Back", tint = Color.Black)
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "Product Details", style = MaterialTheme.typography.h5)
        Spacer(modifier = Modifier.weight(1f))
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
