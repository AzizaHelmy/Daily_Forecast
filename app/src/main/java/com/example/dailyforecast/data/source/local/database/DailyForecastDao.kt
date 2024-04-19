package com.example.dailyforecast.data.source.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.IGNORE
import androidx.room.Query
import com.example.dailyforecast.data.source.local.model.WeatherItemEntity

/**
 * Created by Aziza Helmy on 4/16/2024.
 */
@Dao
interface DailyForecastDao {
    @Insert(onConflict = IGNORE)
    suspend fun insertAllDailyForecastToDb(dailyForecast: List<WeatherItemEntity>)

    @Query("SELECT * FROM dailyForecast")
    fun getAllDailyForecastFromDb(): List<WeatherItemEntity>

}