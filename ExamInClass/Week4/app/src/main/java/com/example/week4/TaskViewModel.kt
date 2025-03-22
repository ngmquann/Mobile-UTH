package com.example.week4

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TaskViewModel: ViewModel() {
    var tasks = mutableStateOf<List<Task>>(emptyList())
    var isLoading = mutableStateOf(true)
    var errorMessage = mutableStateOf("")

    init {
        fetchTasks()
    }

    private fun fetchTasks() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getTasks()
                if (response.isSuccessful) {
                    response.body()?.let { apiResponse ->
                        tasks.value = apiResponse.data
                        isLoading.value = false
                    }
                } else {
                    errorMessage.value = response.message()
                    isLoading.value = false
                }
            } catch (e: Exception) {
                errorMessage.value = "Error: ${e.message}"
                isLoading.value = false
            }
        }
    }
}