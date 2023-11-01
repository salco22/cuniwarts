package com.myapp.cuniwarts.features.housepointscalculator.domain.dao

import com.myapp.cuniwarts.features.housepointscalculator.presentation.utils.CuniwardsHouses

data class HouseWithResult(
    val house: CuniwardsHouses?,
    val points: Int
)
