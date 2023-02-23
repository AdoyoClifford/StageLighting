package com.adoyo.stagelighting.presentation.auth.domain.use_cases

import com.adoyo.stagelighting.presentation.auth.domain.model.User
import com.adoyo.stagelighting.presentation.auth.domain.repository.AuthRepository
import com.adoyo.stagelighting.utils.Resource
import com.adoyo.stagelighting.utils.Result
import javax.inject.Inject

class AuthUseCase @Inject constructor(private val repository: AuthRepository){
    suspend fun signIn(email: String, password: String): Resource<User> {
        return repository.signIn(email, password)
    }

    suspend fun signUp(email: String, password: String): Resource<User> {
        return repository.signUp(email, password)
    }
}