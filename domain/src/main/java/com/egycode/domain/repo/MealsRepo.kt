package com.egycode.domain.repo

import com.egycode.domain.entity.CategoryResponse

interface MealsRepo {
   suspend fun getMealsFromRemote(): CategoryResponse
}