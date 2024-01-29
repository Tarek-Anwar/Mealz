package com.egycode.mealz.di

import com.egycode.data.remote.ApiService
import com.egycode.data.repo.MealsRepoImpl
import com.egycode.domain.repo.MealsRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    fun provideRepo(apiService: ApiService) : MealsRepo{
        return MealsRepoImpl(apiService)
    }
}