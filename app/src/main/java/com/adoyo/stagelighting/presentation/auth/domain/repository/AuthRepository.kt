package com.adoyo.stagelighting.presentation.auth.domain.repository

import com.adoyo.stagelighting.presentation.auth.domain.model.User

interface AuthRepository {
    suspend fun signIn(email: String, password: String): Result<User>
    suspend fun signUp(email: String, password: String): Result<User>
    suspend fun signOut(): Result<Unit>
    suspend fun isUserLoggedIn(): Boolean

}