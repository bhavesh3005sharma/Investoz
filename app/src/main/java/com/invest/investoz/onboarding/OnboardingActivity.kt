package com.invest.investoz.onboarding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.invest.investoz.R

class OnboardingActivity : AppCompatActivity() {

    protected lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)
        initNavController()
    }

    open fun initNavController() {
        (supportFragmentManager.findFragmentById(R.id.authenticationNavigation) as NavHostFragment).let {
            it.navController.graph = it.navController.navInflater.inflate(
                R.navigation.onboarding_navigation )
            navController = it.navController
        }
    }

}