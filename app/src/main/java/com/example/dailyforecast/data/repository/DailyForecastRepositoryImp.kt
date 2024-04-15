package com.example.dailyforecast.data.repository

import com.example.dailyforecast.data.entity.DailyForecast
import com.example.dailyforecast.data.entity.toEntity
import com.example.dailyforecast.data.source.remote.network.DailyForecastService

/**
 * Created by Aziza Helmy on 4/15/2024.
 */
class DailyForecastRepositoryImp(private val dailyForecastService: DailyForecastService) :
    DailyForecastRepository {
    override suspend fun getCurrentWeather(lat: Double, long: Double): DailyForecast {
        return dailyForecastService.getCurrentWeather(lat, long).toEntity()
    }

}