package com.example.week5.domain.usecase

import com.example.week5.data.model.AuthResult
import com.example.week5.domain.repository.AuthRepository
import com.google.android.gms.auth.api.signin.GoogleSignInAccount

class GoogleSignInUsecase(private val authRepository: AuthRepository) {
    suspend operator fun invoke(account: GoogleSignInAccount): AuthResult {
        return authRepository.signInWithGoogle(account)
    }
}