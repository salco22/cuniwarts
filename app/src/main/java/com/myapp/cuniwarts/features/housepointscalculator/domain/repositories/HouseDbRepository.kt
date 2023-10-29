package com.myapp.cuniwarts.features.housepointscalculator.domain.repositories

import com.myapp.cuniwarts.features.housepointscalculator.data.local.entities.HouseDbEntity
import com.myapp.cuniwarts.features.housepointscalculator.domain.components.Operation
import kotlinx.coroutines.flow.Flow

interface HouseDbRepository {

    suspend fun updateSelectedHouse(houseName : String, amount: Int, operation: Operation)

    suspend fun returnAllHouses():Flow<HouseDbEntity>

}