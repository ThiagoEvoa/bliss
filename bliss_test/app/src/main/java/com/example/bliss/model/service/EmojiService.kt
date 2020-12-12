package com.example.bliss.model.service

import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import com.example.bliss.core.RetrofitConfig
import com.example.bliss.viewmodel.EmojiViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EmojiService(private val context: FragmentActivity) : Callback<Map<String, String>> {
    private var emojiViewModel = ViewModelProviders.of(context).get(EmojiViewModel::class.java)

    fun retrieveEmojis() {
        val call = RetrofitConfig().requestEmojis().retrieve()
        call.enqueue(this)
    }

    override fun onResponse(
        call: Call<Map<String, String>>,
        response: Response<Map<String, String>>
    ) {
        emojiViewModel.emojisLiveData.value = response.body()
    }

    override fun onFailure(call: Call<Map<String, String>>, t: Throwable) {
        Toast.makeText(context, "Error while retrieve emojis", Toast.LENGTH_LONG).show()
    }
}