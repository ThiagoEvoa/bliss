package com.example.bliss.core

import androidx.fragment.app.FragmentActivity

fun getStringMessage(context: FragmentActivity, stringId: Int) : String{
    return context.getString(stringId)
}