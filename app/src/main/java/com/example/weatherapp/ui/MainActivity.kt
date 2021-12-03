package com.example.weatherapp.ui

import android.os.Bundle
import com.example.weatherapp.R
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import org.koin.android.ext.android.inject

class MainActivity : MvpAppCompatActivity() {
    private val navigatorHolder: NavigatorHolder by inject()
    private val router: Router by inject()
    private val navigator = AppNavigator(this, R.id.main_container)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
        router.navigateTo(Screens.cities())
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }
}