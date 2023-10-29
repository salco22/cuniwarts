package com.myapp.cuniwarts.features.housepointscalculator.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.myapp.cuniwarts.features.housepointscalculator.data.local.dao.HouseDao
import com.myapp.cuniwarts.features.housepointscalculator.data.local.entities.HouseDbEntity

@Database(
    entities = [HouseDbEntity::class],
    version = 1
)
abstract class HouseDb : RoomDatabase() {

    abstract val houseDao: HouseDao

    companion object{
        const val DB_NAME = "house_table"
    }

}