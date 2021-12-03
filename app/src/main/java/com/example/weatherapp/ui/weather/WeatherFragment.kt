package com.example.weatherapp.ui.weather

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.weatherapp.R
import com.example.weatherapp.domain.model.AppState
import com.example.weatherapp.domain.model.weather.OpenWeather
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import org.koin.java.KoinJavaComponent.inject

class WeatherFragment : MvpAppCompatFragment(R.layout.weather_fragment), WeatherContract.View {
    companion object {
        private const val CITY_ARG = "CITY_ARG"
        fun newInstance(city: String): WeatherFragment = WeatherFragment().apply {
            arguments = Bundle().apply {
                putString(CITY_ARG, city)
            }
        }
    }

    private lateinit var currentCity: String

    override fun setState(state: AppState<OpenWeather>) {
        when(state){
            is AppState.Success ->{ }
        }
    }
}