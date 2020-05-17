package com.example.submission1

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class League(
    val name: String?,
    val id: String?,
    val desc: String?,
    val image: Int?
) : Parcelable