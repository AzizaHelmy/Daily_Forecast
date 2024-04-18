package com.example.dailyforecast.data.source.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.dailyforecast.data.source.local.model.DailyForecastEntity
import com.example.dailyforecast.data.source.local.model.RoomConverter
import com.example.dailyforecast.data.source.local.model.WeatherEntity

/**
 * Created by Aziza Helmy on 4/17/2024.
 */
@Database(entities = [DailyForecastEntity::class], version = 1)
@TypeConverters(RoomConverter::class)
abstract class DailyForecastDataBase : RoomDatabase() {
    abstract fun getDailyForecastDao(): DailyForecastDao

}