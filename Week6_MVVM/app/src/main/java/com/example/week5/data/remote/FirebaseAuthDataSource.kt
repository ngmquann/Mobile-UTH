package com.example.week5.data.remote

import com.example.week5.data.model.AuthResult
import com.example.week5.data.model.User
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.coroutines.tasks.await
import java.lang.Exception

class FirebaseAuthDataSource {
    private val firebaseAuth = FirebaseAuth.getInstance()

    suspend fun signInWithGoogle(account: GoogleSignInAccount): AuthResult {
        return try {
            var credential = GoogleAuthProvider.getCredential(account.idToken, null)
            var authResult = firebaseAuth.signInWithCredential(credential).await()

            authResult.user?.let { firebaseUser ->
                AuthResult.Success(
                    User(
                        uid = firebaseUser.uid,
                        name = firebaseUser.displayName,
                        email = firebaseUser.email,
                        photoUrl = firebaseUser.photoUrl?.toString()
                    )
                )
            } ?: AuthResult.Error("Authentication failed")
        } catch (e: Exception) {
            if (e.message?.contains("canceled", ignoreCase = true) == true) {
                AuthResult.Canceled
            } else {
                AuthResult.Error(e.message ?: "Authentication failed")
            }
        }
    }

    fun getCurrentUser(): User? {
        val firebaseUser = firebaseAuth.currentUser ?: return null

        return User(
            uid = firebaseUser.uid,
            name = firebaseUser.displayName,
            email = firebaseUser.email,
            photoUrl = firebaseUser.photoUrl?.toString()
        )
    }

    fun signOut() {
        firebaseAuth.signOut()
    }
}