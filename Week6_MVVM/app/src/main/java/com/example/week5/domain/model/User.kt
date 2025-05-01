package com.example.week5.domain.model

data class User(
    val uid: String = "",
    val name: String? = null,
    val email: String? = null,
    val photoUrl: String? = null
)