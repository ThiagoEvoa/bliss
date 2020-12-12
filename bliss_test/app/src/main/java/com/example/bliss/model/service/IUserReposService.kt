package com.example.bliss.model.service

import com.example.bliss.model.Repo
import com.example.bliss.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface IUserReposService {
    @GET("users/{username}/repos")
    fun retrieve(@Path("username") username: String): Call<MutableList<Repo>>
}