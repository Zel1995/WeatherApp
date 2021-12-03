package com.example.weatherapp.domain.usecases

import com.example.weatherapp.domain.model.weather.OpenWeather
import io.reactivex.Single

class WeatherInteractorImpl:WeatherInteractor<OpenWeather> {
    override fun getWeather(): Single<OpenWeather> {
        TODO("Not yet implemented")
    }
}