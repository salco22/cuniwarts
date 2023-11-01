package com.myapp.cuniwarts.features.housepointscalculator.presentation.globalview

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myapp.cuniwarts.features.housepointscalculator.domain.components.Operation
import com.myapp.cuniwarts.features.housepointscalculator.domain.repositories.HouseDbRepository
import com.myapp.cuniwarts.features.housepointscalculator.presentation.utils.CuniwardsHouses
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GlobalViewModel @Inject constructor(
    private val repository: HouseDbRepository
) : ViewModel() {

    private var actualValue : Int = 0
    private var actualOperation: Operation = Operation.SUM


    fun addValue(value: Int){
        actualValue += value
    }

    fun subValue(value: Int){
        actualValue -= value
        if (actualValue < 0) actualValue = 0
    }

    fun selectedOperation(operation: Operation) {
        actualOperation = operation
    }

    fun updateHouseValue(house: CuniwardsHouses) {
        viewModelScope.launch {
            repository.updateSelectedHouse(
                houseName = house.id,
                amount = actualValue,
                operation = actualOperation
            )
        }
    }

}