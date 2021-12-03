package com.example.weatherapp.ui.cities

import androidx.fragment.app.Fragment
import com.example.weatherapp.R
import com.example.weatherapp.domain.model.AppState

class CitiesFragment : Fragment(R.layout.fragment_cities), CitiesContract.View {


    override fun setState(state: AppState<String>) {
        TODO("Not yet implemented")
    }

}