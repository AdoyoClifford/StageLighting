package com.adoyo.stagelighting.presentation.auth.domain.repository

import com.adoyo.stagelighting.presentation.auth.domain.model.User
import com.adoyo.stagelighting.utils.Resource
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun signIn(email: String, password: String): Flow<Resource<String>>
    suspend fun signUp(email: String, password: String): Flow<Resource<String>>

}