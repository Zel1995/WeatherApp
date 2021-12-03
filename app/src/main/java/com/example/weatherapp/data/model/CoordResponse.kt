package com.example.weatherapp.data.model

import com.google.gson.annotations.SerializedName

data class CoordResponse (
    @SerializedName("lon")
    val lon: Double,
    @SerializedName("lat")
    val lat: Double
)
