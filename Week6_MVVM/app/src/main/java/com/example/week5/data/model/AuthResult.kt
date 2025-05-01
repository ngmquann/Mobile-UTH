package com.example.week5.data.model

sealed class AuthResult {
    data class Success(val user: User) : AuthResult();
    data class Error(val message: String) : AuthResult();
    object Loading: AuthResult()
    object Canceled: AuthResult()
}