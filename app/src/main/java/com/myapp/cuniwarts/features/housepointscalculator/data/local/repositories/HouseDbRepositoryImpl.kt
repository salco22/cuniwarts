package com.myapp.cuniwarts.features.housepointscalculator.data.local.repositories

import com.myapp.cuniwarts.features.housepointscalculator.data.local.dao.HouseDao
import com.myapp.cuniwarts.features.housepointscalculator.data.local.entities.HouseDbEntity
import com.myapp.cuniwarts.features.housepointscalculator.domain.components.Operation
import com.myapp.cuniwarts.features.housepointscalculator.domain.repositories.HouseDbRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HouseDbRepositoryImpl @Inject constructor(
    private val dao: HouseDao
): HouseDbRepository {

    override suspend fun updateSelectedHouse(houseName: String, amount: Int, operation: Operation) {
        try {
            val house = dao.getSelectedHouse(houseName)

            house?.let {

                val newValue =  it.points + when(operation){
                    Operation.SUM -> amount
                    else -> -amount
                }
                it.points = newValue

                dao.insertData(it)

            } ?: kotlin.run {
                val newEntity = HouseDbEntity(
                    houseName = houseName,
                    points = when(operation){
                        Operation.SUM -> amount
                        else -> -amount
                    }
                )

                dao.insertData(newEntity)

            }
        }catch (e: Exception){
            e.printStackTrace()
        }
    }

    override suspend fun returnAllHouses(): Flow<List<HouseDbEntity>> {
        return dao.getAllHouses()
    }


}