package com.example.weatherapp.ui.weather

import com.example.weatherapp.domain.model.Error
import com.example.weatherapp.domain.model.Loading
import com.example.weatherapp.domain.usecases.WeatherInteractor
import com.example.weatherapp.rx.ISchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign

class WeatherPresenter(
    private val weatherInteractor: WeatherInteractor,
    private val compositeDisposable: CompositeDisposable = CompositeDisposable(),
    private val schedulerProvider: ISchedulerProvider

) :
    WeatherContract.Presenter() {
    override fun renderData(city: String) {
        compositeDisposable += weatherInteractor.getWeather(city)
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
            .doOnSubscribe { viewState.setState(Loading(true)) }
            .subscribe({
                viewState.setState(it)
            }, {
                viewState.setState(Error(it))
            })
    }
}