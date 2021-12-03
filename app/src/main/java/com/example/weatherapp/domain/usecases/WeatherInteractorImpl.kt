package com.example.weatherapp.domain.usecases

import com.example.weatherapp.domain.model.AppState
import com.example.weatherapp.domain.model.weather.OpenWeather
import com.example.weatherapp.domain.repository.WeatherRepository
import io.reactivex.Single

class WeatherInteractorImpl(private val repository:WeatherRepository):WeatherInteractor<OpenWeather>  {
    override fun getWeather(): Single<OpenWeather> {
        TODO("Not yet implemented")
    }
}