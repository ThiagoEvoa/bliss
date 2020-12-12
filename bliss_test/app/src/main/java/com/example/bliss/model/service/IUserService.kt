package com.example.bliss.model.service

import com.example.bliss.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface IUserService {
    @GET("users/{username}")
    fun retrieve(@Path("username") username: String): Call<User>
}