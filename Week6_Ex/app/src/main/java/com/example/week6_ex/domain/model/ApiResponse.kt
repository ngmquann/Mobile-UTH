package com.example.week6_ex.domain.model

data class ApiResponse<T>(
    val isSuccess: Boolean,
    val message: String,
    val data: T
)
