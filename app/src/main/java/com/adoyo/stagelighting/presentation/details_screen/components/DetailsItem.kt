package com.adoyo.stagelighting.presentation.details_screen.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.adoyo.stagelighting.R
import com.adoyo.stagelighting.data.allItems

@Composable
fun DetailsItem(ItemId: Int) {
    val item = allItems.find { it.id == ItemId }
    Column (modifier = Modifier.fillMaxSize()){
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(item?.image)
                .crossfade(true)
                .build(),
            // placeholder = painterResource(R.drawable.placeholder),
            contentDescription = stringResource(R.string.description),
            // contentScale = ContentScale.Crop,
            modifier = Modifier.size(360.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        item?.let {
            Text(
                text = it.name,
                style = TextStyle(
                    fontSize = MaterialTheme.typography.h6.fontSize,
                    fontWeight = FontWeight.Bold
                )
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Information",
            style = TextStyle(
                fontSize = MaterialTheme.typography.body2.fontSize,
                fontWeight = FontWeight(200)
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        item?.let {
            Text(
                text = it.description,
                style = TextStyle(fontSize = MaterialTheme.typography.subtitle1.fontSize,
                fontWeight = FontWeight(300)
                )
            )
        }

    }

}