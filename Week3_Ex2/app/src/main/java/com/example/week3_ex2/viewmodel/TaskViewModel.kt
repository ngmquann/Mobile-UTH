package com.example.week3_ex2.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.week3_ex2.data.model.Task
import com.example.week3_ex2.data.repository.TaskRepository
import kotlinx.coroutines.launch

class TaskViewModel(private val repository: TaskRepository = TaskRepository()) : ViewModel() {
    private val _tasks = mutableStateOf<List<Task>>(emptyList())
    val tasks: State<List<Task>> = _tasks

    private val _error = mutableStateOf<String?>(null)
    val error: State<String?> = _error

    init {
        fetchTasks()
    }

    private fun fetchTasks() {
        viewModelScope.launch {
            val result = repository.getTasks()
            result.onSuccess { taskList ->
                _tasks.value = taskList
                _error.value = null
            }.onFailure { exception ->
                _error.value = exception.message
            }
        }
    }
}