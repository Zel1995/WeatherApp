package com.example.weatherapp.data.mapper

import com.example.weatherapp.data.model.*
import com.example.weatherapp.domain.model.weather.*

class FromResponseToUiWeather {
    fun toOpenWeather(openWeatherResponse: OpenWeatherResponse): OpenWeather {
        return OpenWeather(
            toCoord(openWeatherResponse.coord),
            openWeatherResponse.weather.map { toWeather(it) },
            openWeatherResponse.base,
            toMain(openWeatherResponse.main),
            openWeatherResponse.visibility,
            openWeatherResponse.wind,
            toClouds(openWeatherResponse.clouds),
            openWeatherResponse.dt,
            toSys(openWeatherResponse.sys),
            openWeatherResponse.timezone,
            openWeatherResponse.id,
            openWeatherResponse.name,
            openWeatherResponse.cod
        )
    }
    private fun toCoord(coordResponse: CoordResponse):Coord{
        return Coord(
            coordResponse.lon,
            coordResponse.lat
        )
    }
    private fun toWeather(weatherResponse: WeatherResponse):Weather{
        return Weather(
            weatherResponse.id,
            weatherResponse.main,
            weatherResponse.description,
            weatherResponse.icon
        )
    }
    private fun toMain(mainResponse:MainResponse ):Main{
        return Main(
            mainResponse.temp,
            mainResponse.feelsLike,
            mainResponse.tempMin,
            mainResponse.tempMax,
            mainResponse.pressure,
            mainResponse.humidity
        )
    }
    private fun toClouds(cloudsResponse: CloudsResponse):Clouds{
        return Clouds(
            cloudsResponse.all
        )
    }
    private fun toSys(sysResponse: SysResponse):Sys{
        return Sys(
            sysResponse.type,
            sysResponse.id,
            sysResponse.country,
            sysResponse.sunrise,
            sysResponse.sunset,
        )
    }
}