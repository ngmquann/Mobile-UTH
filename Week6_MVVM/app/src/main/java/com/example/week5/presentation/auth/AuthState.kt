package com.example.week5.presentation.auth

import com.example.week5.domain.model.User

sealed class AuthState {
    object Initial : AuthState()
    object Loading : AuthState()
    data class Authenticated(val user: User) : AuthState()
    object Unauthenticated : AuthState()
    data class Error(val message: String) : AuthState()
    object Canceled : AuthState()
}