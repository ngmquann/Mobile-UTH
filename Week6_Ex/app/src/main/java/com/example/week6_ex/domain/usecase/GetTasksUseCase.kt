package com.example.week6_ex.domain.usecase

import com.example.week6_ex.domain.model.Task
import com.example.week6_ex.domain.repository.TaskRepository

class GetTasksUseCase(private val taskRepository: TaskRepository) {
    suspend operator fun invoke(): List<Task> = taskRepository.getTasks()
}