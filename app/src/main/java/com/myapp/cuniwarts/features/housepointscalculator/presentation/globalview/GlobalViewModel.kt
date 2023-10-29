package com.myapp.cuniwarts.features.housepointscalculator.presentation.globalview

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GlobalViewModel @Inject constructor() : ViewModel() {

    private var actualValue : Int = 0

    private fun fetchDataFromDB(){}


    fun addValue(value: Int){
        actualValue += value
    }

    fun subValue(value: Int){
        actualValue -= value
        if (actualValue < 0) actualValue = 0
    }

}