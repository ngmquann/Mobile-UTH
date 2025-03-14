package com.example.week3_ex2

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
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

@Composable
fun ThirdScreen(navController: NavController){
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding(),
        topBar = {
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                PageIndicator(totalPages = 3, currentPage = 2, modifier = Modifier.padding(top = 12.dp, start = 12.dp))
                TextButton(onClick = {}) {
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
            val painter = painterResource(R.drawable.message)
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
                Text("Reminder Notification", fontWeight = FontWeight.W500, fontSize = 16.sp)
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    "The advantage of this application is that it also provides reminders for you so you don't forget to keep doing your assignments well and according to the time you have set",
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth()
            ){
                Button(
                    onClick = { navController.navigate("second") },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2196F3)),
                    shape = CircleShape,
                    contentPadding = PaddingValues(0.dp),
                    modifier = Modifier.size(50.dp)
                ) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
                }
                Spacer(modifier = Modifier.width(20.dp))
                Button(
                    onClick = {  },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2196F3)),
                    modifier = Modifier.height(50.dp).fillMaxWidth()
                ) {
                    Text("Next", fontWeight = FontWeight.W700, fontSize = 20.sp)
                }
            }
        }
    }
}