package com.example.a160420069utsproject.model

import com.google.gson.annotations.SerializedName

data class Library(
    val id:String?,
    val title:String?,
    @SerializedName("description")
    val desc:String?,
    @SerializedName("url")
    val photoUrl:String?
)