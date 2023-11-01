package com.myapp.cuniwarts.features.housepointscalculator.presentation.resultview

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myapp.cuniwarts.features.housepointscalculator.domain.HousesResultUseCase
import com.myapp.cuniwarts.features.housepointscalculator.domain.dao.HouseWithResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ResultViewModel @Inject constructor(
    private val useCase: HousesResultUseCase
): ViewModel() {

    private val _houses : MutableStateFlow<List<HouseWithResult>> = MutableStateFlow(emptyList())
    val houses: StateFlow<List<HouseWithResult>> get() = _houses

    fun returnHousesWithPoints(){
        viewModelScope.launch {
            useCase.invoke()
                .collect{
                    _houses.value = it
                }
        }
    }
}