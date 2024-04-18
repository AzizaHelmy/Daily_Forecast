package com.example.dailyforecast.data.repository

import com.example.dailyforecast.data.entity.WeatherItem
import com.example.dailyforecast.data.source.local.model.CityList

/**
 * Created by Aziza Helmy on 4/15/2024.
 */
interface DailyForecastRepository {
    suspend fun getCurrentWeather(lat: Double, long: Double): List<WeatherItem>
    suspend fun insertAllDailyForecastToDb(dailyForecast: List<WeatherItem>)
    suspend fun getAllDailyForecastFromDb():List<WeatherItem>
    suspend fun getCities(): CityList

}