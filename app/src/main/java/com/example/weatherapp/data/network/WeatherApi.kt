package com.example.weatherapp.data.network

import com.example.weatherapp.data.model.OpenWeatherResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query


interface WeatherApi {
    @GET("data/2.5/weather")
    fun getWeather(@Query("q")cityName:String,
    @Query("appid")key:String,
    @Query("units")units:String = "metric"):Single<OpenWeatherResponse>
}