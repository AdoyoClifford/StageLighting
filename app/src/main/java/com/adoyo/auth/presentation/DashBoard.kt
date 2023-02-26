package com.adoyo.auth.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.adoyo.stagelighting.R

@Composable
fun DashBoard() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), horizontalAlignment = Alignment.Start
    ) {
        Text("Sound & Vision", style = TextStyle(fontSize = 30.sp))
        Spacer(modifier = Modifier.height(20.dp))
        Card(elevation = 4.dp, modifier = Modifier.fillMaxWidth()) {
            Column {
                Text("Moving Heads", style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp))
                Row (modifier = Modifier.fillMaxWidth()){
                    Text(text = "Moving stage heads are lighting fixtures commonly used in stage productions, concerts, and other events. They are typically mounted on a rigging system and are capable of moving in various directions, including up and down, left and right, and spinning around their axis.")
                    Image(painter = painterResource(id = R.drawable.led), contentDescription = null )

                }
            }
        }
    }
}