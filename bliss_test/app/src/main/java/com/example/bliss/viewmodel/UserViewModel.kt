package com.example.bliss.viewmodel

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bliss.model.Repo
import com.example.bliss.model.User
import com.example.bliss.model.service.UserReposService
import com.example.bliss.model.service.UserService

class UserViewModel : ViewModel() {
    val context = MutableLiveData<FragmentActivity>()
    var userLivaData = MutableLiveData<User>()
    var userReposLiveData = MutableLiveData<MutableList<Repo>>()

    fun retrieveUser(username: String) {
        context.value?.let {
            UserService(it).retrieveUser(username)
        }
    }

    fun retrieveUserRepos() {
        context.value?.let {
            UserReposService(it).retrieveUser(this.userLivaData.value!!.login)
        }
    }
}