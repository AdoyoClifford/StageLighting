package com.adoyo.stagelighting.presentation.details_screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.adoyo.stagelighting.R
import com.adoyo.stagelighting.data.allItems

@Composable
fun DetailsScreen(itemId: Int) {
    val item = allItems.first { it.id == itemId }
    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "Details Screen") }) },
    ) {paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(item.image)
                    .crossfade(true)
                    .build(),
                contentDescription = stringResource(R.string.description),
                modifier = Modifier.aspectRatio(1f)
            )
            Text(
                text = item.name,
                style = MaterialTheme.typography.h5,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.fillMaxWidth()
                    .padding(paddingValues)
            )
            Text(
                text = "${item.price}",
                style = MaterialTheme.typography.h6,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = item.category.toString(),
                style = MaterialTheme.typography.body1,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}




