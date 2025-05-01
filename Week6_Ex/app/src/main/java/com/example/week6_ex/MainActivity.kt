package com.example.week6_ex

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
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.week6_ex.data.remote.RetrofitClient
import com.example.week6_ex.data.remote.TaskApi
import com.example.week6_ex.data.repository.TaskRepositoryImpl
import com.example.week6_ex.domain.usecase.GetTasksUseCase
import com.example.week6_ex.presentation.add.AddScreen
import com.example.week6_ex.presentation.home.HomeScreen
import com.example.week6_ex.presentation.viewmodel.TaskViewModel
import com.example.week6_ex.presentation.viewmodel.TaskViewModelFactory
import com.example.week6_ex.ui.theme.Week6_ExTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val api = RetrofitClient.apiService
        val repository = TaskRepositoryImpl(api)
        val useCase = GetTasksUseCase(repository)
        val viewModelFactory = TaskViewModelFactory(useCase)

        val taskViewModel = ViewModelProvider(this, viewModelFactory)[TaskViewModel::class.java]
        enableEdgeToEdge()
        setContent {
            Week6_ExTheme {
                MyApplication(taskViewModel)
            }
        }
    }
}

@Composable
fun MyApplication(taskViewModel: TaskViewModel){
    var navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home", builder = {
        composable("home") {
            HomeScreen(viewModel = taskViewModel, navController = navController)
        }
        composable("add") {
            AddScreen(navController = navController)
        }
    })
}
