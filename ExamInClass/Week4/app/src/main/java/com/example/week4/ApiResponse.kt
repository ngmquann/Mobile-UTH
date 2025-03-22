package com.example.week4

data class ApiResponse<T> (
    val isSuccess: Boolean,
    val message: String,
    val data: T
)
