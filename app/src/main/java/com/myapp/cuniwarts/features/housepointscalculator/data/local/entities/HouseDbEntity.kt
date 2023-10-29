package com.myapp.cuniwarts.features.housepointscalculator.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.myapp.cuniwarts.features.housepointscalculator.data.local.db.HouseDb

@Entity(tableName = HouseDb.DB_NAME)
data class HouseDbEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val houseName : String,
    var points: Int = 0
)