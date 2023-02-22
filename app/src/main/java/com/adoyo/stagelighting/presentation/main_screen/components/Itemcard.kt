package com.adoyo.stagelighting.presentation.main_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.adoyo.stagelighting.R
import com.adoyo.stagelighting.data.Item
import com.adoyo.stagelighting.ui.theme.AweSomeGrey
import com.adoyo.stagelighting.ui.theme.AwesomeBlue
import com.adoyo.stagelighting.ui.theme.AwesomeRed

@Composable
fun ItemCard(item: Item, onClick: (Item) -> Unit) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { onClick(item) }
            .background(AweSomeGrey),
        elevation = 2.dp
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.padding(8.dp)
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
            Text(
                text = item.name,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                style = TextStyle(fontSize = MaterialTheme.typography.subtitle2.fontSize)
            )
            Text(
                text = "$ ${item.price}",
                style = TextStyle(
                    fontSize = MaterialTheme.typography.subtitle1.fontSize,
                    fontWeight = FontWeight.Bold,
                    color = AwesomeRed
                )
            )
        }
    }
}