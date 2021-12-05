package com.example.weatherapp.ui

import android.os.Bundle
import com.example.weatherapp.R
import com.example.weatherapp.ui.weather.WeatherFragment
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import org.koin.android.ext.android.inject

class MainActivity : MvpAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        supportFragmentManager.beginTransaction().replace(R.id.main_container,WeatherFragment.newInstance("dmitrov")).commit()
    }

    override fun onPause() {
        super.onPause()
    }
}