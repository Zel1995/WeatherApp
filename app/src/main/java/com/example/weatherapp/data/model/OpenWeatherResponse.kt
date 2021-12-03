package com.example.weatherapp.data.model

import com.example.weatherapp.domain.model.Wind
import com.google.gson.annotations.SerializedName

data class OpenWeatherResponse(
    @SerializedName("coord") val coord: CoordResponse,
    @SerializedName("weather") val weather: List<WeatherResponse>,
    @SerializedName("base") val base: String,
    @SerializedName("main") val main: MainResponse,
    @SerializedName("visibility") val visibility: Long,
    @SerializedName("wind") val wind: Wind,
    @SerializedName("wind") val clouds: CloudsResponse,
    @SerializedName("dt") val dt: Long,
    @SerializedName("sys") val sys: SysResponse,
    @SerializedName("timezone") val timezone: Long,
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String,
    @SerializedName("cod") val cod: Long
)
