package com.example.week2_ex2.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun ManageScreen() {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Icon on the screen
        Icon(
            imageVector = Icons.Default.Home,
            contentDescription = "home",
            tint = Color(0xFF0F9D58)
        )
        // Text on the screen
        Text(text = "Home", color = Color.Black)
    }
}

@Composable
fun BookScreen() {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Icon on the screen
        Icon(
            imageVector = Icons.Default.AccountBox,
            contentDescription = "Books",
            tint = Color(0xFF0F9D58)
        )
        // Text on the screen
        Text(text = "Books", color = Color.Black)
    }
}

@Composable
fun UserScreen() {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Icon on the screen
        Icon(
            imageVector = Icons.Default.AccountCircle,
            contentDescription = "User",
            tint = Color(0xFF0F9D58)
        )
        // Text on the screen
        Text(text = "User", color = Color.Black)
    }
}