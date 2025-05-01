package com.example.week5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.week5.di.AppModule
import com.example.week5.presentation.auth.AuthScreen
import com.example.week5.ui.theme.Week5Theme
import com.example.week5.presentation.auth.AuthViewModel
import com.example.week5.util.GoogleSignInHelper
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.common.api.ApiException

class MainActivity : ComponentActivity() {
    private lateinit var authViewModel: AuthViewModel
    private val googleSignInHelper by lazy { GoogleSignInHelper(this) }

    private val googleSignInLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
        try {
            val account = task.getResult(ApiException::class.java)
            authViewModel.signInGoogle(account)
        } catch (e: ApiException) {
            // Handle sign-in failure in the ViewModel
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val appModule = AppModule()
        authViewModel = appModule.provideAuthViewModel()

        setContent {
            val state by authViewModel.authState.collectAsState()
            Week5Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App(
                        onGoogleSignInClick = {
                            launchGoogleSignIn()
                        }
                    )
                }
            }
        }
    }

    private fun launchGoogleSignIn() {
        val signInIntent = googleSignInHelper.getSignInIntent()
        googleSignInLauncher.launch(signInIntent)
    }

    @Composable
    fun App(onGoogleSignInClick: () -> Unit) {
        AuthScreen(
            viewModel = authViewModel,
            onAuthenticated = {
                // Navigate to home screen after successful authentication
            },
            onGoogleSignInClick = onGoogleSignInClick
        )
    }
}