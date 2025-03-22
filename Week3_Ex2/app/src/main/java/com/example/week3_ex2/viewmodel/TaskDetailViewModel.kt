package com.example.week3_ex2.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.week3_ex2.data.model.Task
import com.example.week3_ex2.data.repository.TaskRepository
import kotlinx.coroutines.launch

class TaskDetailViewModel(private val repository: TaskRepository = TaskRepository()) : ViewModel() {
    private val _task = mutableStateOf<Task?>(null)
    val task: State<Task?> = _task

    private val _error = mutableStateOf<String?>(null)
    val error: State<String?> = _error

    fun fetchTask(id: Int) {
        viewModelScope.launch {
            val result = repository.getTask(id)
            result.onSuccess { task ->
                _task.value = task
                _error.value = null
            }.onFailure { exception ->
                _error.value = exception.message
            }
        }
    }
}