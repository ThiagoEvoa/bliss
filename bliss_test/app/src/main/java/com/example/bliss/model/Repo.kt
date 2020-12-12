package com.example.bliss.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Repo(val url: String, val owner: Owner): Parcelable