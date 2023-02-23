package com.adoyo.stagelighting.presentation.auth.di

import com.adoyo.stagelighting.presentation.auth.data.repository.AuthRepositoryImplementation
import com.adoyo.stagelighting.presentation.auth.domain.repository.AuthRepository
import com.adoyo.stagelighting.presentation.auth.presentation.AuthViewModel
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)

object AuthModule {
    @Provides
    fun provideFireBaseAuth(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }

    @Provides
    fun provideAuthRepository(firebaseAuth: FirebaseAuth): AuthRepository {
        return AuthRepositoryImplementation(firebaseAuth)
    }

    @Provides
    fun provide authUseCase(authRepository: AuthRepository): AuthUseCase {
        return AuthUseCase(authRepository)
    }

    @Provides
    fun provideAuthViewModel(authUseCase: AuthUseCase): AuthViewModel {
        return AuthViewModel(authUseCase)
    }
}