package com.example.weatherapp.data.repository

import com.example.weatherapp.data.network.WeatherApi
import com.example.weatherapp.domain.model.weather.OpenWeather
import com.example.weatherapp.domain.repository.WeatherRepository
import io.reactivex.Single

class WeatherRepositoryImpl(private val weatherApi: WeatherApi):WeatherRepository {
    override fun getWeather(cityName: String): Single<OpenWeather> {
        TODO("Not yet implemented")
    }
}