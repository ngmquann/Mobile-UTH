package com.example.week4_ex2.data.remote

import com.example.week4_ex2.data.model.ApiResponse
import com.example.week4_ex2.data.model.Task
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface TaskApiService {
    @GET("tasks")
    suspend fun getTasks(): Response<ApiResponse<List<Task>>>

    @GET("task/{id}")
    suspend fun getTask(@Path("id") id: Int): Response<ApiResponse<Task>>
}