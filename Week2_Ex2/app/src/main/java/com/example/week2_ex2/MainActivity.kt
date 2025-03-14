package com.example.week2_ex2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.week2_ex2.components.BookScreen
import com.example.week2_ex2.components.ManageScreen
import com.example.week2_ex2.components.UserScreen
import com.example.week2_ex2.ui.theme.Week2_Ex2Theme
import com.example.week2_ex2.utils.Constants

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Week2_Ex2Theme(dynamicColor = false, darkTheme = false) {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    LibraryApp(
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
                val navController = rememberNavController()
                Surface (color = Color.White) {
                    // Scaffold Component
                    Scaffold(
                        // Bottom navigation
                        bottomBar = {
                            BottomNavigationBar(navController = navController)
                        }, content = { padding ->
                            // Nav host: where screens are placed
                            NavHostContainer(navController = navController, padding = padding)
                        }
                    )
                }
            }
        }
    }
}

data class User(val id: Int, val name: String)
data class Book(val id: Int, val name: String, var isBorrowed: Boolean = false, var borrowedBy: User? = null)

@Composable
fun LibraryApp(modifier: Modifier = Modifier) {

}

@Composable
fun NavHostContainer(
    navController: NavHostController,
    padding: PaddingValues
) {

    NavHost(
        navController = navController,

        // set the start destination as home
        startDestination = "manage",

        // Set the padding provided by scaffold
        modifier = Modifier.padding(paddingValues = padding),

        builder = {

            // route : Home
            composable("manage") {
                ManageScreen()
            }

            // route : search
            composable("books") {
                BookScreen()
            }

            // route : profile
            composable("user") {
                UserScreen()
            }
        })
}


@Composable
fun BottomNavigationBar(navController: NavHostController) {

    NavigationBar (
        // set background color
        containerColor = Color(0xFF0F9D58)
    ) {

        // observe the backstack
        val navBackStackEntry by navController.currentBackStackEntryAsState()

        // observe current route to change the icon
        // color,label color when navigated
        val currentRoute = navBackStackEntry?.destination?.route

        // Bottom nav items we declared
        Constants.BottomNavItems.forEach { navItem ->

            // Place the bottom nav items
            NavigationBarItem(

                // it currentRoute is equal then its selected route
                selected = currentRoute == navItem.route,

                // navigate on click
                onClick = {
                    navController.navigate(navItem.route)
                },

                // Icon of navItem
                icon = {
                    Icon(imageVector = navItem.icon, contentDescription = navItem.label)
                },

                // label
                label = {
                    Text(text = navItem.label)
                },
                alwaysShowLabel = false,

                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.White, // Icon color when selected
                    unselectedIconColor = Color.White, // Icon color when not selected
                    selectedTextColor = Color.White, // Label color when selected
                    indicatorColor = Color(0xFF195334) // Highlight color for selected item
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Week2_Ex2Theme {
        val navController = rememberNavController()
        Surface (color = Color.White) {
            // Scaffold Component
            Scaffold(
                // Bottom navigation
                bottomBar = {
                    BottomNavigationBar(navController = navController)
                }, content = { padding ->
                    // Nav host: where screens are placed
                    NavHostContainer(navController = navController, padding = padding)
                }
            )
        }
    }
}