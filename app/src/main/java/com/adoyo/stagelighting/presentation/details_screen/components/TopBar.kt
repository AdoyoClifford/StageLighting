package com.adoyo.stagelighting.presentation.details_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.adoyo.stagelighting.ui.theme.AweSomeGrey
import com.adoyo.stagelighting.ui.theme.AwesomeBlue
import com.adoyo.stagelighting.ui.theme.AwesomeGreen
import com.adoyo.stagelighting.ui.theme.AwesomeWhite

@Composable
fun DetailsTopBar(navController: NavController) {
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
        IconButton(
            onClick = { },
            modifier = Modifier
                .clip(CircleShape)
                .background(AwesomeWhite)
        ) {

            Icon(Icons.Outlined.ShoppingCart, contentDescription = "Cart", tint = Color.Yellow)
        }
    }
}
