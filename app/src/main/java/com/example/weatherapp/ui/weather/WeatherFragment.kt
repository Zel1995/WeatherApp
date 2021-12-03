package com.example.weatherapp.ui.weather

import android.os.Bundle
import com.example.weatherapp.R
import com.example.weatherapp.domain.model.AppState
import com.example.weatherapp.domain.model.weather.OpenWeather
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import org.koin.android.ext.android.inject

class WeatherFragment : MvpAppCompatFragment(R.layout.weather_fragment), WeatherContract.View {
    companion object {
        private const val CITY_ARG = "CITY_ARG"
        fun newInstance(city: String): WeatherFragment = WeatherFragment().apply {
            arguments = Bundle().apply {
                putString(CITY_ARG, city)
            }
        }
    }
    private val weatherPresenter:WeatherPresenter by inject()
    private val presenter by moxyPresenter { weatherPresenter }

    private lateinit var currentCity: String

    override fun setState(state: AppState<OpenWeather>) {
        when(state){
            is AppState.Success ->{ }
        }
    }
}