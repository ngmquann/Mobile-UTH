package com.example.week3.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextDetail(navController: NavController, modifier: Modifier = Modifier) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding(),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "Text Detail",
                        style = TextStyle(
                            fontSize = 24.sp,
                            color = Color(0xFF2196F3),
                            fontWeight = FontWeight.W600
                        )
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Localized description"
                        )
                    }
                },
            )
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Hello", fontSize = 16.sp)
            Text("Hello", style = TextStyle(textDecoration = TextDecoration.LineThrough, fontSize = 16.sp))
            Text("Hello", style = TextStyle(fontSize = 16.sp, color = Color.Red))
            Text("Hello", style = TextStyle(fontSize = 16.sp), letterSpacing = TextUnit(value = 4f, type = TextUnitType.Sp))
            Text("Hello", style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 16.sp, fontStyle = FontStyle.Italic))
            Text("Hello", style = TextStyle(textDecoration = TextDecoration.Underline, fontSize = 16.sp))
            Text("Hello", style = TextStyle(fontFamily = FontFamily.Monospace, fontSize = 16.sp))
        }
    }
}