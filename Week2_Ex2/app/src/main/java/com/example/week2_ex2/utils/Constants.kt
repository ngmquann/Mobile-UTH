package com.example.week2_ex2.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.week2_ex2.models.BottomNavItem

object Constants {
    val BottomNavItems = listOf(
        BottomNavItem(
            label = "Manage",
            icon = Icons.Outlined.Home,
            route = "manage"
        ),
        BottomNavItem(
            label = "Books",
            icon = Icons.Default.AccountBox,
            route = "books"
        ),
        BottomNavItem(
            label = "User",
            icon = Icons.Default.AccountCircle,
            route = "user"
        ),
    )
}