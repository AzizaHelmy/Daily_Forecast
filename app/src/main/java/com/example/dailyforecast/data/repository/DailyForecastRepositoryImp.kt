package com.example.dailyforecast.data.repository

import com.example.dailyforecast.data.entity.City
import com.example.dailyforecast.data.entity.WeatherItem
import com.example.dailyforecast.data.entity.toLocalEntity
import com.example.dailyforecast.data.source.local.database.DailyForecastDao
import com.example.dailyforecast.data.source.local.model.toEntity
import com.example.dailyforecast.data.source.remote.model.toEntity
import com.example.dailyforecast.data.source.remote.network.DailyForecastService
import com.example.dailyforecast.data.source.service.CityService
import com.example.dailyforecast.data.utils.DailyForecastState

/**
 * Created by Aziza Helmy on 4/15/2024.
 */
class DailyForecastRepositoryImp(
    private val cityService: CityService,
    private val dailyForecastService: DailyForecastService,
    private val diaDailyForecastLocalDb: DailyForecastDao
) :
    DailyForecastRepository {
    override suspend fun getDailyForecast(
        lat: Double,
        long: Double
    ): Pair<List<WeatherItem>, DailyForecastState> {
        val networkWeather = getDailyForecastFromNetwork(lat, long)
        return if (!networkWeather.isNullOrEmpty()) {
            insertAllDailyForecastToLocal(networkWeather)
            Pair(networkWeather, DailyForecastState.NETWORK)
        } else {
            val localWeather = getAllDailyForecastFromLocal()
            Pair(localWeather, DailyForecastState.DATABASE)
        }
    }

    override suspend fun getDailyForecastFromNetwork(
        lat: Double,
        long: Double
    ): List<WeatherItem>? {
        return try {
            dailyForecastService.getDailyForecast(lat, long).toEntity()
        } catch (e: Exception) {
            null
        }
    }

    override suspend fun insertAllDailyForecastToLocal(dailyForecast: List<WeatherItem>) {
        diaDailyForecastLocalDb.insertAllDailyForecastToDb(
            dailyForecast.toLocalEntity()
        )
    }

    override suspend fun getAllDailyForecastFromLocal(): List<WeatherItem> {
        return diaDailyForecastLocalDb.getAllDailyForecastFromDb().toEntity()
    }

    override suspend fun getCities(): List<City> {
        return cityService.getCities()
    }

}