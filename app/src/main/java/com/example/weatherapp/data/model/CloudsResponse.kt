package com.example.weatherapp.data.model

import com.google.gson.annotations.SerializedName

data class CloudsResponse (
    @SerializedName("all")
    val all: Long
)