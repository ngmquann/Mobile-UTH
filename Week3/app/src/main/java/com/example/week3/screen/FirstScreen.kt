package com.example.week3.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.week3.R

@Composable
fun FirstScreen(navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 40.dp, start = 40.dp, end = 40.dp, bottom = 10.dp)
    ) {
        val painter = painterResource(R.drawable.image1)
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier
                    .weight(1f, fill = false)
                    .aspectRatio(painter.intrinsicSize.width / painter.intrinsicSize.height)
                    .fillMaxSize()
            )
            Spacer(modifier = Modifier.height(30.dp))
            Text("Jetpack Compose", fontWeight = FontWeight.W500, fontSize = 16.sp)
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                "Jetpack Compose is a modern UI toolkit for building native Android applications using a declarative programming approach.",
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
            )
        }
        Button(
            onClick = { navController.navigate("components") },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2196F3)),
            modifier = Modifier.height(50.dp).fillMaxWidth()
        ) {
            Text("I'm ready", fontWeight = FontWeight.W700, fontSize = 20.sp)
        }
    }
}