package com.example.week5.data.repository

import com.example.week5.data.model.AuthResult
import com.example.week5.data.remote.FirebaseAuthDataSource
import com.example.week5.domain.model.User
import com.example.week5.domain.repository.AuthRepository
import com.google.android.gms.auth.api.signin.GoogleSignInAccount

class AuthRepositoryImpl(private val firebaseAuthDataSource: FirebaseAuthDataSource): AuthRepository {
    override suspend fun signInWithGoogle(account: GoogleSignInAccount): AuthResult {
        return firebaseAuthDataSource.signInWithGoogle(account)
    }

    override fun getCurrentUser(): User? {
        val user = firebaseAuthDataSource.getCurrentUser() ?: return null

        return User(
            uid = user.uid,
            name = user.name,
            email = user.email,
            photoUrl = user.photoUrl
        )
    }

    override fun signOut() {
        firebaseAuthDataSource.signOut()
    }
}