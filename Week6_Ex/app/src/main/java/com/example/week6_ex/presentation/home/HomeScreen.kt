package com.example.week6_ex.presentation.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.week6_ex.presentation.viewmodel.TaskViewModel

@Composable
fun HomeScreen(viewModel: TaskViewModel, navController: NavController) {
    val items = listOf("Home", "Calendar", "Document", "Settings")
    val icons = listOf(
        Icons.Default.Home,
        Icons.Default.DateRange,
        Icons.Default.Description,
        Icons.Default.Settings
    )
    val tasks = viewModel.tasks

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding(),
        bottomBar = {
            BottomAppBar(
                containerColor = Color.White,
                tonalElevation = 8.dp,
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    for (i in items.indices) {
                        if (i == 2) {
                            Spacer(Modifier.width(56.dp))
                        }

                        IconButton(onClick = { /* handle click */ }) {
                            Icon(
                                imageVector = icons[i],
                                contentDescription = items[i],
                                tint = if (i == 0) Color(0xFF2196F3) else Color.Gray
                            )
                        }
                    }
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate("add")
                },
                containerColor = Color(0xFF2196F3),
                shape = CircleShape,
                elevation = FloatingActionButtonDefaults.elevation(8.dp),
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add", tint = Color.White)
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
    ) { innerPadding ->
        Column {
            Header()
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                items(tasks) { task ->
                    CardComponent(
                        title = task.title,
                        description = task.description,
                    )
                }
            }
        }
    }
}

@Composable
fun CardComponent(
    title: String,
    description: String,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = CardDefaults.cardColors(
            Color(0xffE1BBC1)
        ),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = title, fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Text(
                text = description,
                fontSize = 14.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
fun Header() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBackIos,
            contentDescription = ""
        )
        Text(
            "List",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xff2196F3)
        )
        Icon(
            imageVector = Icons.Default.AddCircle,
            contentDescription = ""
        )
    }
}