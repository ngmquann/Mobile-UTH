package com.example.week3.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.week3.component.ComponentCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComponentsScreen(navController: NavController) {
    Scaffold(modifier = Modifier
        .fillMaxSize()
        .statusBarsPadding(),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "UI Components List",
                        style = TextStyle(
                            fontSize = 24.sp,
                            color = Color(0xFF2196F3),
                            fontWeight = FontWeight.W600
                        )
                    )
                }
            )
        }) { innerPadding ->
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
        ) {
            Text(
                "Display",
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 16.sp),
                modifier = Modifier.padding(start = 16.dp)
            )
            ComponentCard(
                "Text",
                "Displays text",
                onClick = { navController.navigate("text-detail") })
            ComponentCard(
                "Image",
                "Display an image",
                onClick = { navController.navigate("image-detail") })

            Text(
                "Input",
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 16.sp),
                modifier = Modifier.padding(start = 16.dp)
            )
            ComponentCard(
                "TextField",
                "Input field for text",
                onClick = { navController.navigate("text-field-detail") })
            ComponentCard(
                "PasswordField",
                "Input field for passwords",
                onClick = { navController.navigate("password-field-detail") })

            Text(
                "Button",
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 16.sp),
                modifier = Modifier.padding(start = 16.dp)
            )
            ComponentCard(
                "Switch",
                "Toggle between two states",
                onClick = { navController.navigate("switch-detail") })
            ComponentCard("Slider", "To make selections from a range of values", onClick = {navController.navigate("slider-detail")})

            Text(
                "Layout",
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 16.sp),
                modifier = Modifier.padding(start = 16.dp)
            )
            ComponentCard("Column", "Arranges elements vertically", onClick = {})
            ComponentCard("Row", "Arranges elements horizontally", onClick = {})
        }
    }
}