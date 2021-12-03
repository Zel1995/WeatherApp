package com.example.weatherapp.domain.usecases

import io.reactivex.Single

interface WeatherInteractor<T> {
    fun getWeather():Single<T>
}