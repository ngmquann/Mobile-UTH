package com.example.week5.presentation.auth

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

@Composable
fun AuthScreen(viewModel: AuthViewModel, onAuthenticated: () -> Unit, onGoogleSignInClick: () -> Unit){
    val authState by viewModel.authState.collectAsState()

    when (authState) {
        is AuthState.Authenticated -> {
            val user = (authState as AuthState.Authenticated).user
            LoginSuccessScreen(
                email = user.email ?: "",
                onContinue = onAuthenticated,
                viewModel = viewModel
            )
        }
        is AuthState.Canceled -> {
            LoginFailedScreen(
                message = "User canceled the Google sign-in process.",
                onRetry = { /* Will be handled by MainActivity */ }
            )
        }
        is AuthState.Error -> {
            val errorMessage = (authState as AuthState.Error).message
            LoginFailedScreen(
                message = errorMessage,
                onRetry = { /* Will be handled by MainActivity */ }
            )
        }
        AuthState.Initial, AuthState.Loading -> {
            LoginScreen(
                isLoading = authState is AuthState.Loading,
                onGoogleSignInClick = onGoogleSignInClick
            )
        }
        AuthState.Unauthenticated -> {
            LoginScreen(
                isLoading = false,
                onGoogleSignInClick = onGoogleSignInClick
            )
        }
    }
}