package com.invest.investoz.onboarding

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.invest.investoz.model.User

class OnboardingActivityViewModel : ViewModel() {

    val detail = MutableLiveData(User())
}