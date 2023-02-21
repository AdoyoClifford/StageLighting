package com.adoyo.stagelighting.feature_product.presentation.items

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.adoyo.stagelighting.R
import com.adoyo.stagelighting.feature_product.domain.model.Items

@Composable
fun StageItem(item: Items,onItemClick: (Items) -> Unit) {
    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { onItemClick(item) }
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(item.image)
                    .crossfade(true)
                    .build(),
                //placeholder = painterResource(R.drawable.placeholder),
                contentDescription = stringResource(R.string.description),
                //contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(140.dp)
            )
            Text(text = item.title, overflow = TextOverflow.Ellipsis, maxLines = 1)
           // Text(text = "${details.price}")
        }
    }
}