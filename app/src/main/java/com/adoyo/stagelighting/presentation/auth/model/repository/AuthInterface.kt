package com.adoyo.stagelighting.presentation.auth.model.repository

import com.adoyo.stagelighting.utils.Resource

interface AuthInterface {
    suspend fun signIn(email: String, password: String): Resource<Unit>
    suspend fun signUp(email: String, password: String): Resource<Unit>
    suspend fun signOut(): Resource<Unit>
    suspend fun isUserLoggedIn(): Boolean

}