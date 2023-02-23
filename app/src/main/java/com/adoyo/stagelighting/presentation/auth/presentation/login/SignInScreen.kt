package com.adoyo.stagelighting.presentation.auth.presentation.login

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.adoyo.stagelighting.presentation.auth.presentation.AuthViewModel
import com.adoyo.stagelighting.ui.theme.AwesomeWhite
import com.adoyo.stagelighting.ui.theme.DarkBlue

@Composable
fun SignInScreen(authViewModel: AuthViewModel = hiltViewModel()) {
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
                text = "Email", style = TextStyle(
                    fontSize = MaterialTheme.typography.h5.fontSize,
                    fontWeight = FontWeight(200), color = DarkBlue
                )
            )
            OutlinedTextField(
                value = authViewModel.email.value,
                onValueChange = { authViewModel.onEmailChange(it) },
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
                value = authViewModel.password.value,
                onValueChange = { authViewModel.onPasswordChange(it) },
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
                onClick = {
                    authViewModel.signIn(
                        authViewModel.email.value,
                        authViewModel.password.value
                    )
                },
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