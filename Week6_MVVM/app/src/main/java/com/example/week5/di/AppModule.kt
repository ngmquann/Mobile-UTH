package com.example.week5.di

import com.example.week5.data.remote.FirebaseAuthDataSource
import com.example.week5.data.repository.AuthRepositoryImpl
import com.example.week5.domain.repository.AuthRepository
import com.example.week5.domain.usecase.GetCurrentUserUseCase
import com.example.week5.domain.usecase.GoogleSignInUsecase
import com.example.week5.domain.usecase.SignOutUsecase
import com.example.week5.presentation.auth.AuthViewModel

class AppModule {
    // Data sources
    fun provideFirebaseAuthDataSource(): FirebaseAuthDataSource {
        return FirebaseAuthDataSource()
    }

    // Repositories
    fun provideAuthRepository(): AuthRepository {
        return AuthRepositoryImpl(provideFirebaseAuthDataSource())
    }

    // Use cases
    fun provideGoogleSignInUseCase(): GoogleSignInUsecase {
        return GoogleSignInUsecase(provideAuthRepository())
    }

    fun provideGetCurrentUserUseCase(): GetCurrentUserUseCase {
        return GetCurrentUserUseCase(provideAuthRepository())
    }

    fun provideSignOutUseCase(): SignOutUsecase {
        return SignOutUsecase(provideAuthRepository())
    }

    // ViewModels
    fun provideAuthViewModel(): AuthViewModel {
        return AuthViewModel(
            provideGoogleSignInUseCase(),
            provideGetCurrentUserUseCase(),
            provideSignOutUseCase()
        )
    }
}