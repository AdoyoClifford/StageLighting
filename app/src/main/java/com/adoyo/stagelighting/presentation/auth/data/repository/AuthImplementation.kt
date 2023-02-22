package com.adoyo.stagelighting.presentation.auth.data.repository

import com.adoyo.stagelighting.presentation.auth.model.AuthError
import com.adoyo.stagelighting.presentation.auth.model.repository.AuthInterface
import com.adoyo.stagelighting.utils.Resource
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await


class AuthImplementation: AuthInterface {
    private val auth = FirebaseAuth.getInstance()
    override suspend fun signIn(email: String, password: String): Resource<Unit> {
        return try {
            auth.signInWithEmailAndPassword(email, password)
            Resource.Success(Unit)
        } catch (e: FirebaseAuthInvalidUserException) {
            Resource.Error(AuthError.UserNotFound.toString())
        } catch (e: FirebaseAuthInvalidCredentialsException) {
            Resource.Error(AuthError.InvalidCredentials.toString())
        } catch (e: Exception) {
            Resource.Error(AuthError.NetworkError.toString())
        }
    }

    override suspend fun signUp(email: String, password: String): Resource<Unit> {
        return try {
            auth.createUserWithEmailAndPassword(email, password).await()
            Resource.Success(Unit)
        } catch (e: Exception) {
            Resource.Error(AuthError.NetworkError.toString())
        }
    }

    override suspend fun signOut(): Resource<Unit> {
        return try {
            auth.signOut()
            Resource.Success(Unit)
        } catch (e: Exception) {
            Resource.Error(AuthError.NetworkError.toString())
        }
    }

    override suspend fun isUserLoggedIn(): Boolean {
        return auth.currentUser != null
    }

}