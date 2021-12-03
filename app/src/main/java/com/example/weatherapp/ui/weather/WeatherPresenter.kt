package com.example.weatherapp.ui.weather

import com.example.weatherapp.domain.model.AppState
import com.example.weatherapp.domain.model.weather.OpenWeather
import com.example.weatherapp.domain.usecases.WeatherInteractor
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class WeatherPresenter(private val weatherInteractor: WeatherInteractor<AppState<OpenWeather>>) :
    WeatherContract.Presenter() {
    override fun onCity(city: String) {
        weatherInteractor.getWeather()
            .subscribeOn(AndroidSchedulers.mainThread())
            .observeOn(Schedulers.io())
            .subscribe({},{})
    }
}