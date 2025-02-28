package com.dev.jarassignment.viewmodel

import androidx.lifecycle.ViewModel
import com.dev.jarassignment.data.repository.OnboardingRepo
import javax.inject.Inject

class OnboardingViewModel @Inject constructor(private val repository: OnboardingRepo): ViewModel() {
}