package com.example.week6_ex.presentation.add

import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddScreen(navController: NavController) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding(),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "Add New",
                        style = TextStyle(
                            fontSize = 24.sp,
                            color = Color(0xFF2196F3),
                            fontWeight = FontWeight.W600
                        ),
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = { navController.popBackStack() }
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = ""
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxWidth()
        ) {
            FormAdd()
        }

    }
}

@Composable
fun FormAdd(modifier: Modifier) {
    var text by remember { mutableStateOf("") }
    Column {
        Text("Task")
        TextField(
            value = text,
            onValueChange = { text = it },
        )
    }
}

@Composable
fun FormAdd() {
    var textTask by remember {
        mutableStateOf("")
    }
    var textDescription by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(30.dp)
    ) {
        Text(
            "Task", style = TextStyle(
                fontWeight = FontWeight.W600,
                fontSize = 15.sp
            )
        )
        TextField(
            value = textTask,
            onValueChange = { textTask = it },
            placeholder = { Text("Do homework") },
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                errorIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .border(width = 1.dp, shape = RoundedCornerShape(10.dp), color = Color.Gray),
        )
        Spacer(
            modifier = Modifier.height(10.dp)
        )
        Text(
            "Description", style = TextStyle(
                fontWeight = FontWeight.W600,
                fontSize = 15.sp
            )
        )
        TextField(
            value = textDescription,
            onValueChange = { textDescription = it },
            placeholder = { Text("Don’t give up") },
            maxLines = 4,
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                errorIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .border(width = 1.dp, shape = RoundedCornerShape(10.dp), color = Color.Gray),
        )
        Spacer(
            modifier = Modifier.height(10.dp)
        )
        Button(
            onClick = {},
            modifier = Modifier.align(Alignment.CenterHorizontally),
            shape = RoundedCornerShape(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xff2196F3),
                contentColor = Color.White
            )
        ) {
            Box(
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "Add", fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}
