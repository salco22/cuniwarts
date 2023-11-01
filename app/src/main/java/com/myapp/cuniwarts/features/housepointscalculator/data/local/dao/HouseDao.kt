package com.myapp.cuniwarts.features.housepointscalculator.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.myapp.cuniwarts.features.housepointscalculator.data.local.entities.HouseDbEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface HouseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(entity: HouseDbEntity)

    @Query("SELECT * FROM house_table WHERE houseName = :house")
    suspend fun getSelectedHouse(house : String): HouseDbEntity?

    @Query("SELECT * FROM house_table")
    fun getAllHouses(): Flow<List<HouseDbEntity>>

}