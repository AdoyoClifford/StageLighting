package com.adoyo.stagelighting.presentation.auth.data.repository

import com.adoyo.stagelighting.presentation.auth.domain.repository.AuthRepository
import com.adoyo.stagelighting.utils.Resource
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject


class AuthRepositoryImplementation @Inject constructor(private val firebaseAuth: FirebaseAuth) :
    AuthRepository {

    override suspend fun signIn(email: String, password: String): Flow<Resource<String>> = flow {
        emit(Resource.Loading())
        try {
            val result = firebaseAuth.signInWithEmailAndPassword(email, password).await()
            val user = result.user
            user?.let {
                emit(Resource.Success(user.uid))
            } ?: run {
                emit(Resource.Error("Unable to sign up please try again"))
            }
        } catch (e: Exception) {
            emit(Resource.Error("Unable to sign in please try again"))
        }
    }

    override suspend fun signUp(email: String, password: String): Flow<Resource<String>> = flow {
        emit(Resource.Loading())
        try {
            val result = firebaseAuth.createUserWithEmailAndPassword(email, password).await()
            val user = result.user
            user?.let {
                emit(Resource.Success(user.uid))
            } ?: run {
                emit(Resource.Error("Unable to sign up. Please try again."))
            }
        } catch (e: Exception) {
            emit(Resource.Error("Unable to sign up. Please try again."))
        }
    }
}

