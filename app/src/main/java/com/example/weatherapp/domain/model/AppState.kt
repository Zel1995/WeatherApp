package com.example.weatherapp.domain.model

sealed class AppState<T> {
    class Success<T>(value :T): AppState<T>()
    class Error<T>(error:Throwable): AppState<T>()
    class Loading<T>(isLoading:Boolean): AppState<T>()
}