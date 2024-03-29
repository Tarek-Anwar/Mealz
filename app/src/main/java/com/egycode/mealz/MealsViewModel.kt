package com.egycode.mealz

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.egycode.domain.entity.CategoryResponse
import com.egycode.domain.usecase.GetMeals
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealsViewModel @Inject constructor(
    private val getMealsUseCase: GetMeals,
) : ViewModel() {
    private val TAG = "MealsViewModel"

    private val _categories : MutableStateFlow<CategoryResponse?> = MutableStateFlow(null)
    val categories : StateFlow<CategoryResponse?> = _categories

    fun getMeals() {
        viewModelScope.launch {
            try {
                _categories.value = getMealsUseCase()
            }catch (e : Exception){
                Log.d(TAG, "getMeals: ${e.message.toString()}")
            }
        }
    }
}