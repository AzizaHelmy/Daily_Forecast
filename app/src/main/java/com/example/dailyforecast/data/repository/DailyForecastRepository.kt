package com.example.dailyforecast.data.repository

import com.example.dailyforecast.data.entity.DailyForecast
import com.example.dailyforecast.data.source.local.model.CityList
import com.example.dailyforecast.data.source.local.model.WeatherEntity

/**
 * Created by Aziza Helmy on 4/15/2024.
 */
interface DailyForecastRepository {
    suspend fun getCurrentWeather(lat: Double, long: Double): DailyForecast
    suspend fun insertAllDailyForecastToDb(dailyForecast: WeatherEntity)
    suspend fun getAllDailyForecastFromDb():WeatherEntity
    suspend fun getCities(): CityList

}