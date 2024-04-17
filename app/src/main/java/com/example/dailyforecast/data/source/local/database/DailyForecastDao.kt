package com.example.dailyforecast.data.source.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.IGNORE
import androidx.room.Query
import com.example.dailyforecast.data.source.local.model.WeatherEntity

/**
 * Created by Aziza Helmy on 4/16/2024.
 */
@Dao
interface DailyForecastDao {
    @Insert(onConflict = IGNORE)
    suspend fun insertAllDailyForecastToDb(dailyForecast: WeatherEntity) //todo: add correct table

    @Query("SELECT * FROM weather") //todo: change table later
    fun getAllDailyForecastFromDb(): WeatherEntity

}