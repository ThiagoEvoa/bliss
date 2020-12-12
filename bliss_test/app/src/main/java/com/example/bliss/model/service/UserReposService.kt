package com.example.bliss.model.service

import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import com.example.bliss.core.RetrofitConfig
import com.example.bliss.model.Repo
import com.example.bliss.viewmodel.UserViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserReposService(private val context: FragmentActivity): Callback<MutableList<Repo>> {
    private var userViewModel = ViewModelProviders.of(context).get(UserViewModel::class.java)

    fun retrieveUser(userName: String) {
        val call = RetrofitConfig().requestUserRepos().retrieve(userName)
        call.enqueue(this)
    }

    override fun onResponse(call: Call<MutableList<Repo>>, response: Response<MutableList<Repo>>) {
        userViewModel.userReposLiveData.value = response.body()
    }

    override fun onFailure(call: Call<MutableList<Repo>>, t: Throwable) {
        Toast.makeText(context, "Error while retrieve repos", Toast.LENGTH_LONG).show()
    }
}