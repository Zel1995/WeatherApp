package com.example.weatherapp.domain.repository

import com.example.weatherapp.domain.model.weather.OpenWeather
import io.reactivex.Single

interface WeatherRepository {
    fun getWeather(cityName: String):Single<OpenWeather>
}