package com.example.bliss.model.service

import retrofit2.Call
import retrofit2.http.GET

interface IEmojiService {
    @GET("emojis")
    fun retrieve(): Call<Map<String, String>>
}