package com.example.bliss.model.service

import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import com.example.bliss.core.RetrofitConfig
import com.example.bliss.model.User
import com.example.bliss.viewmodel.UserViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserService(private val context: FragmentActivity) : Callback<User> {
    private var userViewModel = ViewModelProviders.of(context).get(UserViewModel::class.java)

    fun retrieveUser(userName: String) {
        val call = RetrofitConfig().requestUser().retrieve(userName)
        call.enqueue(this)
    }

    override fun onResponse(call: Call<User>, response: Response<User>) {
        userViewModel.userLivaData.value = response.body()
    }

    override fun onFailure(call: Call<User>, t: Throwable) {
        Toast.makeText(context, "Error while retrieve user", Toast.LENGTH_LONG).show()
    }
}