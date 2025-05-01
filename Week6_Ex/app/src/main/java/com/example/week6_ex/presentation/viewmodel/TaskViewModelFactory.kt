package com.example.week6_ex.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.week6_ex.domain.usecase.GetTasksUseCase

class TaskViewModelFactory(private val getTasksUseCase: GetTasksUseCase): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(TaskViewModel::class.java)){
            return TaskViewModel(getTasksUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}