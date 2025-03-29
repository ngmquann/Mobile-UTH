package com.example.week3_ex2.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.week3_ex2.R

@Composable
fun LoginScreen(navController: NavController, modifier: Modifier = Modifier){
    Box(modifier = modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.background_img),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            alpha = 0.4f,
            modifier = modifier.fillMaxWidth()
        )
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 60.dp, start = 40.dp, end = 40.dp, bottom = 10.dp)
    ) {
        Text("SmartTasks")
    }
}