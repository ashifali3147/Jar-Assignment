package com.dev.jarassignment.data.network

import com.dev.jarassignment.data.model.BaseResponse
import com.dev.jarassignment.data.model.OnboardingBaseModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("0a095cf2-a081-44af-965a-953b0fa6499b")
    suspend fun getOnboardingData(): Response<BaseResponse<OnboardingBaseModel>>
}