package com.myapp.cuniwarts.di

import android.app.Application
import androidx.room.Room
import com.myapp.cuniwarts.features.housepointscalculator.data.local.db.HouseDb
import com.myapp.cuniwarts.features.housepointscalculator.data.local.repositories.HouseDbRepositoryImpl
import com.myapp.cuniwarts.features.housepointscalculator.domain.repositories.HouseDbRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppProviderModule {

    @Provides
    @Singleton
    fun provideHouseDataBase(app: Application): HouseDb =
        Room.databaseBuilder(
            app,
            HouseDb::class.java,
            HouseDb.DB_NAME
        ).build()

    @Provides
    @Singleton
    fun provideHouseDbRepository(db: HouseDb):HouseDbRepository =
        HouseDbRepositoryImpl(
            db.houseDao
        )

}