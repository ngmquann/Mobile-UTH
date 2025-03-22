package com.example.week3_ex2.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.week3_ex2.R

@Composable
fun FirstScreen(navController: NavController) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding(),
        topBar = {
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                PageIndicator(totalPages = 3, currentPage = 0, modifier = Modifier.padding(top = 12.dp, start = 12.dp))
                TextButton(onClick = { navController.navigate("list") }) {
                    Text("Skip", style = TextStyle(fontSize = 14.sp, color = Color(0xff006EE9)))
                }
            }
        }
    ) { innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 60.dp, start = 40.dp, end = 40.dp, bottom = 10.dp)
                .padding(innerPadding)
        ) {
            val painter = painterResource(R.drawable.portfolio)
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
                Text("Easy Time Management", fontWeight = FontWeight.W500, fontSize = 16.sp)
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    "With management based on priority and daily tasks, it will give you convenience in managing and determining the tasks that must be done first ",
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                )
            }
            Button(
                onClick = { navController.navigate("second") },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2196F3)),
                modifier = Modifier.height(50.dp).fillMaxWidth()
            ) {
                Text("Next", fontWeight = FontWeight.W700, fontSize = 20.sp)
            }
        }
    }
}