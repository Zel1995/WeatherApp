package com.example.weatherapp.domain.usecases

import com.example.weatherapp.domain.model.AppState
import com.example.weatherapp.domain.model.weather.OpenWeather
import io.reactivex.Single

interface WeatherInteractor {
    fun getWeather(cityName:String):Single<AppState<OpenWeather>>
}