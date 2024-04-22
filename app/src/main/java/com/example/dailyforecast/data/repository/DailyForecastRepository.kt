package com.example.dailyforecast.data.repository

import com.example.dailyforecast.data.entity.City
import com.example.dailyforecast.data.entity.WeatherItem
import com.example.dailyforecast.data.utils.DailyForecastState

/**
 * Created by Aziza Helmy on 4/15/2024.
 */
interface DailyForecastRepository {
    suspend fun getDailyForecast(lat: Double, long: Double): Pair<List<WeatherItem>,DailyForecastState>
    suspend fun getDailyForecastFromNetwork(lat: Double, long: Double): List<WeatherItem>?
    suspend fun insertAllDailyForecastToLocal(dailyForecast: List<WeatherItem>)
    suspend fun getDailyForecastFromLocal(lat: Double, lon: Double): List<WeatherItem>
    suspend fun getCities(): List<City>

}