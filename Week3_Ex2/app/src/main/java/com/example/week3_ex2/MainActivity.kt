package com.example.week3_ex2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.week3_ex2.ui.theme.Week3_Ex2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Week3_Ex2Theme {
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
    var navController = rememberNavController();

    NavHost(navController = navController, startDestination = "first", builder = {
        composable("first") {
            FirstScreen(navController)
        }
        composable("second") {
            SecondScreen(navController)
        }
        composable("third") {
            ThirdScreen(navController)
        }
    })
}

@Preview(showBackground = true)
@Composable
fun MyApplicationPreview() {
    Week3_Ex2Theme {
        MyApplication()
    }
}