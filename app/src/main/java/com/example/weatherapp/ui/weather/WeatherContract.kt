package com.example.weatherapp.ui.weather

import com.example.weatherapp.domain.model.AppState
import com.example.weatherapp.domain.model.weather.OpenWeather
import moxy.MvpPresenter
import moxy.MvpView
import moxy.viewstate.strategy.alias.Skip

abstract class WeatherContract {
    interface View : MvpView {
        @Skip
        fun setState(state: AppState<OpenWeather>)
    }

    abstract class Presenter : MvpPresenter<View>() {
        abstract fun onCity(city: String)
    }
}