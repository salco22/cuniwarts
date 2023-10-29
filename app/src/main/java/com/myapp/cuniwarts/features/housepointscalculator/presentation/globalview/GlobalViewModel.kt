package com.myapp.cuniwarts.features.housepointscalculator.presentation.globalview

import androidx.lifecycle.ViewModel
import com.myapp.cuniwarts.features.housepointscalculator.domain.Operation
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GlobalViewModel @Inject constructor() : ViewModel() {

    private var actualValue : Int = 0
    private var actualOperation: Operation = Operation.SUM

    private fun fetchDataFromDB(){}


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

}