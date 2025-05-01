package com.example.week6_ex.data.model

import com.example.week6_ex.domain.model.ApiResponse

data class ApiResponseDTO<T>(
    val isSuccess: Boolean,
    val message: String,
    val data: T
)

fun <T> ApiResponseDTO<T>.toDomain() : ApiResponse<T>{
    return ApiResponse(
        isSuccess = isSuccess,
        message = message,
        data = data,
    )
}
