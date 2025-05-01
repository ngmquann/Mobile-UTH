package com.example.week5.domain.usecase

import com.example.week5.domain.repository.AuthRepository

class SignOutUsecase(private val authRepository: AuthRepository) {
    operator fun invoke() {
        return authRepository.signOut()
    }
}