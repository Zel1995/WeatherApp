package com.example.weatherapp.ui

import com.example.weatherapp.ui.cities.CitiesFragment
import com.example.weatherapp.ui.weather.WeatherFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    fun weather(city:String ) = FragmentScreen { WeatherFragment.newInstance(city) }
    fun repos() = FragmentScreen { CitiesFragment() }
}