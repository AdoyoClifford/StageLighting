package com.adoyo.auth.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun DashBoard() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text("Sound & Vision", style = TextStyle(fontSize = 30.sp))
        Spacer(modifier = Modifier.height(20.dp))
        Text("Moving Heads", style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp,))
    }
}