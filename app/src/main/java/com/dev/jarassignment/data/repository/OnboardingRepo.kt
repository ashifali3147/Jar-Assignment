package com.dev.jarassignment.data.repository

import com.dev.jarassignment.data.model.BaseResponse
import com.dev.jarassignment.data.model.OnboardingBaseModel
import com.dev.jarassignment.data.network.ApiManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class OnboardingRepo {
    suspend fun fetchPosts():BaseResponse<OnboardingBaseModel>?  {
        return withContext(Dispatchers.IO) {
            val response = ApiManager.service.getOnboardingData()
            if (response.isSuccessful) response.body() else null
        }
    }
}