package com.adoyo.stagelighting.presentation.auth.login

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.adoyo.stagelighting.ui.theme.AwesomeWhite
import com.adoyo.stagelighting.ui.theme.DarkBlue

@Composable
fun SignIn() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), contentAlignment = Alignment.Center
    ) {
        Column {
            Text(
                text = "Sign In", style = TextStyle(
                    fontSize = MaterialTheme.typography.h3.fontSize,
                    fontWeight = FontWeight.Bold, color = DarkBlue
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Name", style = TextStyle(
                    fontSize = MaterialTheme.typography.h5.fontSize,
                    fontWeight = FontWeight(200), color = DarkBlue
                )
            )
            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text(
                        text = "First Name", style = TextStyle(
                            fontSize = MaterialTheme.typography.body1.fontSize,
                            color = Color.Black.copy(alpha = 0.5f)
                        )
                    )
                })
            Text(
                text = "Email", style = TextStyle(
                    fontSize = MaterialTheme.typography.h5.fontSize,
                    fontWeight = FontWeight(200), color = DarkBlue
                )
            )
            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text(
                        text = "Email", style = TextStyle(
                            fontSize = MaterialTheme.typography.body1.fontSize,
                            color = Color.Black.copy(alpha = 0.5f)
                        )
                    )
                })
            Text(
                text = "Password", style = TextStyle(
                    fontSize = MaterialTheme.typography.h5.fontSize,
                    fontWeight = FontWeight(200), color = DarkBlue
                )
            )
            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text(
                        text = "Password", style = TextStyle(
                            fontSize = MaterialTheme.typography.body1.fontSize,
                            color = Color.Black.copy(alpha = 0.5f)
                        )
                    )
                })

            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(backgroundColor = DarkBlue)
            ) {
                Text(
                    text = "Sign In", style = TextStyle(
                        fontSize = MaterialTheme.typography.h5.fontSize,
                        fontWeight = FontWeight(200), color = AwesomeWhite
                    )
                )
            }
        }
    }
}