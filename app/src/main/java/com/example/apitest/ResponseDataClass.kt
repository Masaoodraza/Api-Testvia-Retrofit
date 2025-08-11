package com.example.apitest
// data class for api response
data class ResponseDataClass(
    val completed: Boolean,
    val id: Int,
    val title: String,
    val userId: Int
)