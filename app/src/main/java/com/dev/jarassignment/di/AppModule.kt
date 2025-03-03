package com.dev.jarassignment.di

import com.dev.jarassignment.data.repository.OnboardingRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideOnboardingRepo(): OnboardingRepo = OnboardingRepo()
}