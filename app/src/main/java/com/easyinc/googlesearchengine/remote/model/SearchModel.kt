package com.easyinc.googlesearchengine.remote.model


import com.google.gson.annotations.SerializedName

data class SearchModel(
    @SerializedName("items")
    val items: List<ResultModel>
)