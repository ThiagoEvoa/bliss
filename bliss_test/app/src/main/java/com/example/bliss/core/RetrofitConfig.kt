package com.example.bliss.core

import com.example.bliss.model.service.IEmojiService
import com.example.bliss.model.service.IUserReposService
import com.example.bliss.model.service.IUserService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConfig {
    var retrofit: Retrofit = Retrofit.Builder().baseUrl("https://api.github.com/")
        .addConverterFactory(GsonConverterFactory.create()).build()

    fun requestUser(): IUserService = retrofit.create(IUserService::class.java)

    fun requestUserRepos(): IUserReposService = retrofit.create(IUserReposService::class.java)

    fun requestEmojis(): IEmojiService = retrofit.create(IEmojiService::class.java)
}