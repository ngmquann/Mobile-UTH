package com.example.week3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.week3.detail.ImageDetail
import com.example.week3.detail.PasswordFieldDetail
import com.example.week3.detail.SliderDetail
import com.example.week3.detail.SwitchDetail
import com.example.week3.detail.TextDetail
import com.example.week3.detail.TextFieldDetail
import com.example.week3.screen.ComponentsScreen
import com.example.week3.screen.FirstScreen
import com.example.week3.ui.theme.Week3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Week3Theme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(
                            bottom = WindowInsets.navigationBars.asPaddingValues()
                                .calculateBottomPadding()
                        )
                ) { innerPadding ->
                    MyApplication(modifier = Modifier.padding(innerPadding))
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
        composable("components") {
            ComponentsScreen(navController)
        }
        composable("text-detail") {
            TextDetail(navController)
        }
        composable("image-detail") {
            ImageDetail(navController)
        }
        composable("text-field-detail") {
            TextFieldDetail(navController)
        }
        composable("password-field-detail") {
            PasswordFieldDetail(navController)
        }
        composable("switch-detail") {
            SwitchDetail(navController)
        }
        composable("slider-detail") {
            SliderDetail(navController)
        }
    }, modifier = Modifier.background(Color(0xFFffffff)))
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Week3Theme {
        MyApplication()
    }
}