package com.example.bliss.viewmodel

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bliss.model.service.EmojiService

class EmojiViewModel: ViewModel() {
    val context = MutableLiveData<FragmentActivity>()
    val emojisLiveData = MutableLiveData<Map<String, String>>()

    fun retrieveEmojis(){
        context.value?.let {
            EmojiService(it).retrieveEmojis()
        }
    }
}