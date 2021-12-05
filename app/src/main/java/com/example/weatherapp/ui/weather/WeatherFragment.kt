package com.example.weatherapp.ui.weather

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.weatherapp.R
import com.example.weatherapp.domain.model.AppState
import com.example.weatherapp.domain.model.Error
import com.example.weatherapp.domain.model.Loading
import com.example.weatherapp.domain.model.Success
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

    private var currentCity: String?=null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        currentCity = arguments?.getString(CITY_ARG,"Dmitrov")
        currentCity?.let { presenter.renderData(it) }
        presenter.renderData("London")

    }

    override fun setState(state: AppState<OpenWeather>) {
        when(state){
            is Success ->{
                Toast.makeText(requireContext(),state.value.name,Toast.LENGTH_SHORT).show()
            }
            is Error ->{
                Toast.makeText(requireContext(),state.error.message.toString(),Toast.LENGTH_SHORT).show()
                Log.d("aaaaaaaaddfwa",state.error.toString())
            }
            is Loading ->{}
        }
    }
}