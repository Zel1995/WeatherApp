package com.example.weatherapp.data.repository

import com.example.weatherapp.BuildConfig
import com.example.weatherapp.data.mapper.FromResponseToUiWeather
import com.example.weatherapp.data.network.WeatherApi
import com.example.weatherapp.domain.model.AppState
import com.example.weatherapp.domain.model.Error
import com.example.weatherapp.domain.model.Success
import com.example.weatherapp.domain.model.weather.OpenWeather
import com.example.weatherapp.domain.repository.WeatherRepository
import io.reactivex.Single

class WeatherRepositoryImpl(
    private val weatherApi: WeatherApi,
    private val fromResponseToUiWeather: FromResponseToUiWeather
) : WeatherRepository {
    override fun getWeather(cityName: String): Single<AppState<OpenWeather>> {
        try {
            return weatherApi.getWeather(cityName, BuildConfig.WEATHER_KEY)
                .map { Success(fromResponseToUiWeather.toOpenWeather(it)) }
        } catch (exc: Exception) {
            return Single.just(Error<OpenWeather>(exc))
        }
    }
}