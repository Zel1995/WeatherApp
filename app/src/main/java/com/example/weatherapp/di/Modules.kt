package com.example.weatherapp.di

import com.example.weatherapp.BuildConfig
import com.example.weatherapp.data.network.WeatherApi
import com.example.weatherapp.data.repository.WeatherRepositoryImpl
import com.example.weatherapp.domain.model.weather.OpenWeather
import com.example.weatherapp.domain.repository.WeatherRepository
import com.example.weatherapp.domain.usecases.WeatherInteractor
import com.example.weatherapp.domain.usecases.WeatherInteractorImpl
import com.example.weatherapp.ui.weather.WeatherPresenter
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val repositoryModule = module {
    single<WeatherRepository> { WeatherRepositoryImpl(get()) }
}

val routerModule = module {
    single(named("asd")) { Cicerone.create() }
    single { get<Cicerone<Router>>().router }
    single { get<Cicerone<Router>>().getNavigatorHolder() }
}

val networkModule = module {
    single {
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }
    single {
        get<Retrofit>().create(WeatherApi::class.java)
    }

    factory {
        OkHttpClient.Builder().apply {
            addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY

            })
        }.build()
    }
}

val presenterModule = module {
    factory { WeatherPresenter(get()) }
}

val interactorsModule = module {
    factory<WeatherInteractor<OpenWeather>> { WeatherInteractorImpl(get()) }
}