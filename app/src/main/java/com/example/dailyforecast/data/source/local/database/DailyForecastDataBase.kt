package com.example.dailyforecast.data.source.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.dailyforecast.data.source.local.model.DailyForecastEntity

/**
 * Created by Aziza Helmy on 4/17/2024.
 */
@Database(entities = [DailyForecastEntity::class], version = 1)
abstract class DailyForecastDataBase : RoomDatabase() {
    abstract fun getDailyForecastDao(): DailyForecastDao

}