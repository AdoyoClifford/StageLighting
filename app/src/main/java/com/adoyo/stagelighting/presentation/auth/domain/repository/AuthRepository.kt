package com.adoyo.stagelighting.presentation.auth.domain.repository

import com.adoyo.stagelighting.presentation.auth.domain.model.User
import com.adoyo.stagelighting.utils.Resource

interface AuthRepository {
    suspend fun signIn(email: String, password: String): Resource<User>
    suspend fun signUp(email: String, password: String): Resource<User>
    suspend fun signOut(): Result<Unit>
    suspend fun isUserLoggedIn(): Boolean

}