package com.dev.jarassignment.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.jarassignment.data.model.EducationCard
import com.dev.jarassignment.data.model.OnboardingData
import com.dev.jarassignment.data.repository.OnboardingRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(private val repository: OnboardingRepo) :
    ViewModel() {
    private val _onboardingData = MutableLiveData<OnboardingData?>()
    val onboardingData: LiveData<OnboardingData?> = _onboardingData
    val cardData: MutableList<EducationCard> = mutableListOf()

    init {
        fetchApiData()
    }

    fun fetchApiData() {
        viewModelScope.launch {
            try {
                val response = repository.getOnboardingData()
                if (response?.success == true) {
                    println("Response: ${response.data?.onboardingData?.educationCardList?.size}")
                    cardData.clear()
                    response.data?.onboardingData?.educationCardList?.let { cardData.addAll(it) }
                    println("cardData: ${cardData.size}")
                    _onboardingData.postValue(response.data?.onboardingData)
                } else {
                    Log.e("API_ERROR", "Error:")
                }
            } catch (e: Exception) {
                Log.e("API_ERROR", "Exception: ${e.message}")
            }
        }
    }
}