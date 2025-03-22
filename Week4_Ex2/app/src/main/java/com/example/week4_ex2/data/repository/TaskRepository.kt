package com.example.week4_ex2.data.repository

import com.example.week4_ex2.data.model.Task
import com.example.week4_ex2.data.remote.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TaskRepository {
    suspend fun getTasks(): Result<List<Task>> = withContext(Dispatchers.IO) {
        try {
            val response = RetrofitClient.apiService.getTasks()
            if (response.isSuccessful) {
                val apiResponse = response.body()
                if (apiResponse?.isSuccess == true) {
                    Result.success(apiResponse.data)
                } else {
                    Result.failure(Exception(apiResponse?.message ?: "Unknown error"))
                }
            } else {
                Result.failure(Exception("API call failed: ${response.message()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getTask(id: Int): Result<Task> = withContext(Dispatchers.IO) {
        try {
            val response = RetrofitClient.apiService.getTask(id)
            if (response.isSuccessful) {
                val apiResponse = response.body()
                if (apiResponse?.isSuccess == true) {
                    Result.success(apiResponse.data)
                } else {
                    Result.failure(Exception(apiResponse?.message ?: "Unknown error"))
                }
            } else {
                Result.failure(Exception("API call failed: ${response.message()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}