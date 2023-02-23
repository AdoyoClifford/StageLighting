package com.adoyo.stagelighting.presentation.auth.data.repository

import com.adoyo.stagelighting.presentation.auth.domain.model.User
import com.adoyo.stagelighting.presentation.auth.domain.repository.AuthRepository
import com.adoyo.stagelighting.utils.Resource
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await
import javax.inject.Inject


class AuthRepositoryImplementation @Inject constructor(private val firebaseAuth: FirebaseAuth) :
    AuthRepository {

    override suspend fun signIn(email: String, password: String): Resource<User> {
        return try {
            val authResult = firebaseAuth.signInWithEmailAndPassword(email, password).await()
            Resource.Success(User(authResult.user!!.uid, authResult.user!!.email!!))
        } catch (e: Exception) {
            Resource.Error("Error")
        }
    }

    override suspend fun signUp(email: String, password: String): Resource<User> {
        return try {
            val authResult = firebaseAuth.createUserWithEmailAndPassword(email, password).await()
            Resource.Success(User(authResult.user!!.uid, authResult.user!!.email!!))
        } catch (e: Exception) {
            Resource.Error("Error")
        }
    }

    override suspend fun signOut(): Resource<Unit> {
        return try {
            firebaseAuth.signOut()
            Resource.Success(Unit)
        } catch (e: Exception) {
            Resource.Error("Error")
        }
    }


    override suspend fun isUserLoggedIn(): Boolean {
        return firebaseAuth.currentUser != null
    }

}