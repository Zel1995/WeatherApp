package com.example.weatherapp.domain.model

sealed class AppState<T>
class Success<T>(val value: T) : AppState<T>()
class Error<T>(val error: Throwable) : AppState<T>()
class Loading<T>(val isLoading: Boolean) : AppState<T>()
