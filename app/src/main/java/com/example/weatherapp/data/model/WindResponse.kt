package com.example.weatherapp.data.model

import com.google.gson.annotations.SerializedName

data class WindResponse(
    @SerializedName("speed")val speed: Double,
    @SerializedName("deg")val deg: Long
)
