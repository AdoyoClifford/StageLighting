package com.adoyo.stagelighting.presentation.details_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.adoyo.stagelighting.data.Tab
import com.adoyo.stagelighting.data.allItems

@Composable
fun DetailsBottomBar(ItemId: Int) {
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
            onClick = { /*TODO*/ }, modifier = Modifier
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
    }
}