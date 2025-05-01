package com.example.week6_ex.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.week6_ex.domain.model.Task
import com.example.week6_ex.domain.usecase.GetTasksUseCase
import kotlinx.coroutines.launch

class TaskViewModel(private val getTasksUseCase: GetTasksUseCase): ViewModel() {
    var tasks by mutableStateOf<List<Task>>(emptyList())
        private set

    init {
        viewModelScope.launch {
            tasks = getTasksUseCase()
        }
    }
}