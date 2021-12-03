package com.example.weatherapp.ui.cities

import com.example.weatherapp.domain.model.AppState
import moxy.MvpPresenter
import moxy.MvpView
import moxy.viewstate.strategy.alias.Skip

abstract class CitiesContract {
    interface View : MvpView {
        @Skip
        fun setState(state: AppState<String>)
    }

    abstract class Presenter : MvpPresenter<View>() {
        abstract fun onCity(city: String)
    }
}