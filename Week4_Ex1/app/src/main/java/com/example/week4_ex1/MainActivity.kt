package com.example.week4_ex1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.week4_ex1.screen.DetailScreen
import com.example.week4_ex1.screen.FirstScreen
import com.example.week4_ex1.screen.LazyScreen
import com.example.week4_ex1.ui.theme.Week4_Ex1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Week4_Ex1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyApplication(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MyApplication(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "first", builder = {
        composable("first") {
            FirstScreen(navController)
        }
        composable("lazy") {
            LazyScreen(navController)
        }
        composable(
            "detail/{quote}",
            arguments = listOf(navArgument("quote") { type = NavType.StringType })
        ) { backStackEntry ->
            val quote = backStackEntry.arguments?.getString("quote")
            if (quote != null) {
                DetailScreen(navController = navController, quote = quote)
            }
        }
    }, modifier = Modifier.background(Color(0xFFffffff)))
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Week4_Ex1Theme {
        MyApplication()
    }
}