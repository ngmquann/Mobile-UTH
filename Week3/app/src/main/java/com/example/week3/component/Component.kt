package com.example.week3.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ComponentCard(title: String, description: String, onClick: () -> Unit) {
    Card(
        Modifier
            .padding(start = 16.dp, end = 16.dp, top = 10.dp, bottom = 10.dp)
            .fillMaxWidth()
            .clickable { onClick() },
    ) {
        ListItem(
            headlineContent = {
                Text(
                    title,
                    style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 16.sp)
                )
            },
            supportingContent = { Text(description, style = TextStyle(fontSize = 16.sp)) },
            colors = ListItemDefaults.colors(Color(33, 150, 243, (0.3f * 255).toInt()))
        )
    }
}