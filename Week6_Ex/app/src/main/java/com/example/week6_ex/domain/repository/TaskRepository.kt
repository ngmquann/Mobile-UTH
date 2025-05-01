package com.example.week6_ex.domain.repository

import com.example.week6_ex.domain.model.Task

interface TaskRepository {
    suspend fun getTasks(): List<Task>
}