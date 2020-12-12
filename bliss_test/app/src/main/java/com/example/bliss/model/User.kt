package com.example.bliss.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(val login: String, val avatar_url: String, val repos_url: String) : Parcelable