package com.example.week5.domain.repository

import com.example.week5.data.model.AuthResult
import com.example.week5.domain.model.User
import com.google.android.gms.auth.api.signin.GoogleSignInAccount

interface AuthRepository {
    suspend fun signInWithGoogle(account: GoogleSignInAccount): AuthResult
    fun getCurrentUser(): User?
    fun signOut()
}