package com.example.week5.domain.usecase

import com.example.week5.domain.model.User
import com.example.week5.domain.repository.AuthRepository

class GetCurrentUserUseCase(private val authRepository: AuthRepository) {
    operator fun invoke(): User? {
        return authRepository.getCurrentUser()
    }
}