package com.myapp.cuniwarts.features.housepointscalculator.domain

import com.myapp.cuniwarts.features.housepointscalculator.domain.dao.HouseWithResult
import com.myapp.cuniwarts.features.housepointscalculator.domain.repositories.HouseDbRepository
import com.myapp.cuniwarts.features.housepointscalculator.presentation.utils.CuniwardsHouses
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class HousesResultUseCase @Inject constructor(
    private val repository: HouseDbRepository
) {

    suspend operator fun invoke(): Flow<List<HouseWithResult>> =
        repository.returnAllHouses().map{
            it.map { dbEntity ->
                HouseWithResult(
                    CuniwardsHouses.returnHouseFromName(dbEntity.houseName),
                    dbEntity.points
                )
            }.sortedByDescending { element->
                element.points
            }
        }

}