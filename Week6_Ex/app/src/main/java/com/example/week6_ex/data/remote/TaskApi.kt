package com.example.week6_ex.data.remote

import com.example.week6_ex.data.model.TaskDTO
import com.example.week6_ex.domain.model.ApiResponse
import retrofit2.Response
import retrofit2.http.GET

interface TaskApi {
    @GET("tasks")
    suspend fun getTasks(): Response<ApiResponse<List<TaskDTO>>>
}