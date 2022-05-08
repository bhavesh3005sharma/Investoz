package com.invest.investoz.welcome

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.preference.PreferenceManager
import com.github.paolorotolo.appintro.AppIntro2
import com.google.firebase.auth.FirebaseAuth
import com.invest.investoz.R
import com.invest.investoz.onboarding.OnboardingActivity

class WelcomeActivity : AppIntro2() {

    val mAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val preferences: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        if (preferences.getBoolean("welcome", true)) {
            preferences.edit().putBoolean("welcome", false).apply()
            showIntroSlides()
        } else if(mAuth.currentUser == null){
            goToMain()
        }else {
            goToMain()
            //startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun showIntroSlides() {

        addSlide(CustomTutorialFragment.newInstance(R.layout.intro_first_page))
        addSlide(CustomTutorialFragment.newInstance(R.layout.intro_second_page))
        addSlide(CustomTutorialFragment.newInstance(R.layout.intro_third_page))

        setIndicatorColor(resources.getColor(R.color.orange), resources.getColor(R.color.grey))
        pagerIndicatorEnabled = true
        showStatusBar(false)
        setFadeAnimation()
    }

    private fun goToMain() {
        startActivity(Intent(this, OnboardingActivity::class.java))
        finish()
    }

    override fun onSkipPressed(currentFragment: Fragment?) {
        super.onSkipPressed(currentFragment)
        goToMain()
    }

    override fun onDonePressed(currentFragment: Fragment?) {
        super.onDonePressed(currentFragment)
        goToMain()
    }

    override fun onSlideChanged(oldFragment: Fragment?, newFragment: Fragment?) {
        super.onSlideChanged(oldFragment, newFragment)
        Log.d("Hello", "Changed")
    }

}