package com.example.week5.presentation.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.week5.presentation.components.GoogleSignInButton
import com.example.week5.util.GoogleSignInHelper

@Composable
fun LoginScreen(
    isLoading: Boolean,
    onGoogleSignInClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "MVVM",
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center
            )

            Text(
                text = "MVVM (Model-View-ViewModel)",
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(32.dp))

            GoogleSignInButton(
                text = "Login by Gmail",
                isLoading = isLoading,
                modifier = Modifier.fillMaxWidth(),
                onClick = onGoogleSignInClick
            )
        }
    }
}