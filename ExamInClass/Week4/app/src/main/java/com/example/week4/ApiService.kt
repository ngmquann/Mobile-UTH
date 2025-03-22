package com.example.week4

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("tasks")
    suspend fun getTasks(): Response<ApiResponse<List<Task>>>
}

object RetrofitInstance {
    private const val BASE_URL = "https://amock.io/api/researchUTH/"

    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}