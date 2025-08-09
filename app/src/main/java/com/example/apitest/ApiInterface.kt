package com.example.apitest

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("todos/1")
    fun getData(): Call<ResponseDataClass>
}