package com.adoyo.stagelighting.presentation.auth.domain

sealed class AuthError {
    object InvalidCredentials : AuthError()
    object UserNotFound : AuthError()
    object NetworkError : AuthError()
    // Add more error types as needed
}
