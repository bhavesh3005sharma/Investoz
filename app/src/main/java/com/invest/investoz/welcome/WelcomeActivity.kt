package com.invest.investoz.welcome

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.preference.PreferenceManager
import com.github.paolorotolo.appintro.AppIntro2
import com.invest.investoz.MainActivity
import com.invest.investoz.R
import com.invest.investoz.onboarding.OnboardingActivity

class WelcomeActivity : AppIntro2() {

    private lateinit var manager: PreferenceManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //manager = PreferencesManager(this)
        if (true) {
            showIntroSlides()
        } else {
            goToMain()
        }
    }

    private fun showIntroSlides() {
        //manager.setFirstRun()

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