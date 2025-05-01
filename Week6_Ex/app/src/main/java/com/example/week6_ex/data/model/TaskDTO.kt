package com.example.week6_ex.data.model

import com.example.week6_ex.domain.model.Task

data class TaskDTO(
    val id: Int,
    val title: String,
    val description: String
)

fun TaskDTO.toDomain(): Task {
    return Task(
        id = id,
        title = title,
        description = description
    )
}