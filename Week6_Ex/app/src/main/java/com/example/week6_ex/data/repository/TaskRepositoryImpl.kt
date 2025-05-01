package com.example.week6_ex.data.repository

import com.example.week6_ex.data.model.toDomain
import com.example.week6_ex.data.remote.TaskApi
import com.example.week6_ex.domain.model.Task
import com.example.week6_ex.domain.repository.TaskRepository

class TaskRepositoryImpl(private val api: TaskApi) : TaskRepository {
    override suspend fun getTasks(): List<Task> {
        var response = api.getTasks()
        if (response.isSuccessful) {
            val apiResponse = response.body()
            if (apiResponse?.isSuccess == true) {
                return apiResponse.data.map { it.toDomain() }
            }
        }
        return emptyList()
    }
}