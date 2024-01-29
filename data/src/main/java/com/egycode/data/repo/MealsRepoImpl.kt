package com.egycode.data.repo

import com.egycode.data.remote.ApiService
import com.egycode.domain.entity.CategoryResponse
import com.egycode.domain.repo.MealsRepo

class MealsRepoImpl(private val apiService: ApiService) : MealsRepo {
      override suspend fun getMealsFromRemote(): CategoryResponse = apiService.getMeals()
}