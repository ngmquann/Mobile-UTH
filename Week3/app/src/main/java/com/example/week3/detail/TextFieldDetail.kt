package com.example.week3.detail

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Search
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.week3.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldDetail(navController: NavController){
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding(),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "TextField Detail",
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
            TextField1()
            TextField2()
        }
    }
}

@Composable
fun TextField1() {
    var text by remember {
        mutableStateOf("")
    }
    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("TextField") },
        textStyle = TextStyle(color = Color.Blue),
        supportingText = {
            Text("supportingText")
        },
        placeholder = { Text("placeholder") },
        leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = null) },
        colors = TextFieldDefaults.colors(
            focusedTextColor = Color.Red,
            focusedContainerColor = Color.Green,
            errorContainerColor = Color.Green,
            disabledContainerColor = Color.Green,
            unfocusedContainerColor = Color.Green,
            focusedIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        ),
        shape = RoundedCornerShape(CornerSize(16.dp)),
        prefix = { Text("Mr ") },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Send
        ),
        keyboardActions = KeyboardActions(
            onSend = {
                Log.i("TAG", "send $text")
            }
        )
    )
}

@Composable
fun TextField2() {
    var text by remember {
        mutableStateOf("")
    }
    var isShowPassword by remember {
        mutableStateOf(false)
    }
    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("OutlinedTextField") },
        supportingText = {
            Icon(
                imageVector = Icons.Default.Info,
                contentDescription = null
            )
        },
        trailingIcon = {
            IconButton(onClick = { isShowPassword = !isShowPassword }) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = null
                )
            }
        },
        visualTransformation = if (isShowPassword) VisualTransformation.None else PasswordVisualTransformation()
    )
}