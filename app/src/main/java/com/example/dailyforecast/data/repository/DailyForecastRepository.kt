package com.example.dailyforecast.data.repository

import com.example.dailyforecast.data.entity.DailyForecast

/**
 * Created by Aziza Helmy on 4/15/2024.
 */
interface DailyForecastRepository {
    suspend fun getCurrentWeather(lat: Double, long: Double): DailyForecast

}