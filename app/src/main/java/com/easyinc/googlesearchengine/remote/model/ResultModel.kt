package com.easyinc.googlesearchengine.remote.model


import com.google.gson.annotations.SerializedName

data class ResultModel(
    @SerializedName("link")
    val link: String,
    @SerializedName("snippet")
    val snippet: String,
    @SerializedName("title")
    val title: String
)