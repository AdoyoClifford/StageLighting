package com.adoyo.stagelighting.utils

import com.adoyo.stagelighting.presentation.auth.domain.model.User

sealed class AuthResult {
    data class Success(val user: User) : AuthResult()
    data class Error(val message: String) : AuthResult()
}
