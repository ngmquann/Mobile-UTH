package com.example.week3_ex2.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Attachment
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.GridView
import androidx.compose.material.icons.filled.ListAlt
import androidx.compose.material.icons.filled.MilitaryTech
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.week3_ex2.data.model.Attachment
import com.example.week3_ex2.data.model.Subtask
import com.example.week3_ex2.viewmodel.TaskDetailViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    navController: NavController,
    taskId: Int,
    viewModel: TaskDetailViewModel = viewModel()
) {
    viewModel.fetchTask(taskId)

    val task by viewModel.task
    val error by viewModel.error

    Scaffold(modifier = Modifier
        .fillMaxSize()
        .statusBarsPadding(),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "Detail",
                        style = TextStyle(
                            fontSize = 24.sp,
                            color = Color(0xFF2196F3),
                            fontWeight = FontWeight.W600
                        )
                    )
                },
                navigationIcon = {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .background(
                                color = Color(0xFF09B4FF),
                                shape = RoundedCornerShape(12.dp)
                            )
                            .clickable { navController.popBackStack() },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                            tint = Color.White,
                            contentDescription = "Localized description",
                            modifier = Modifier.size(30.dp)
                        )
                    }
                },
                actions = {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        tint = Color(0xFF2196F3),
                        contentDescription = "",
                        modifier = Modifier.size(30.dp)
                    )
                }
            )
        }) { innerPadding ->
        if (error != null) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Error: $error",
                    color = Color.Red,
                    fontSize = 16.sp
                )
            }
        } else if (task == null) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(horizontal = 16.dp)
            ) {
                item {
                    Text(
                        text = task!!.title,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 16.dp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = task!!.description,
                        fontSize = 16.sp,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(24.dp))

                    Box(
                      contentAlignment = Alignment.Center,
                        modifier = Modifier.fillMaxWidth()
                            .padding(vertical = 2.dp)
                            .background(
                                color = Color(0xFFE1BBC1),
                                shape = RoundedCornerShape(8.dp)
                            )
                            .padding(12.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            Detail(icon = Icons.Default.GridView, title = "Category", content = task!!.category)
                            Spacer(Modifier.width(10.dp))
                            Detail(icon = Icons.Default.ListAlt, title = "Status", content = task!!.status)
                            Spacer(Modifier.width(10.dp))
                            Detail(icon = Icons.Default.MilitaryTech, title = "Priority", content = task!!.priority)
                        }
                    }

                    Spacer(modifier = Modifier.height(24.dp))
                    Text(
                        text = "Subtasks",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }

                // Subtasks List
                items(task!!.subtasks) { subtask ->
                    SubtaskItem(subtask)
                }

                item {
                    Spacer(modifier = Modifier.height(24.dp))

                    // Attachments Section
                    Text(
                        text = "Attachments",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }

                // Attachments List
                items(task!!.attachments) { attachment ->
                    AttachmentItem(attachment)
                }
            }
        }
    }
}

@Composable
fun Detail(icon: ImageVector, title: String, content: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = icon,
            tint = Color.Black,
            contentDescription = "",
            modifier = Modifier
                .size(40.dp)
                .padding(end = 10.dp)
        )
        Column {
            Text(title)
            Text(content, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun SubtaskItem(subtask: Subtask) {
    var checkState by remember { mutableStateOf(subtask.isCompleted) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .background(
                color = Color(0xFFF5F5F5), // Light gray background
                shape = RoundedCornerShape(8.dp) // Rounded corners
            )
            .padding(12.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = checkState,
                onCheckedChange = { checkState = it }
            )
            Text(
                text = subtask.title,
                fontSize = 16.sp,
                color = Color.Black
            )
        }
    }
}

@Composable
fun AttachmentItem(attachment: Attachment) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .background(
                color = Color(0xFFF5F5F5), // Light gray background
                shape = RoundedCornerShape(8.dp) // Rounded corners
            )
            .padding(12.dp)
    ) {
        Row {
            Icon(
                imageVector = Icons.Filled.Attachment,
                tint = Color.Black,
                contentDescription = "",
                modifier = Modifier
                    .size(30.dp)
                    .padding(end = 10.dp)
            )
            Text(
                text = attachment.fileName,
                fontSize = 16.sp,
                color = Color.Black
            )
        }
    }
}