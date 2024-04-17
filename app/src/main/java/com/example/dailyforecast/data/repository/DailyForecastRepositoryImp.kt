package com.example.dailyforecast.data.repository

import android.app.Application
import android.content.Context
import com.example.dailyforecast.data.entity.DailyForecast
import com.example.dailyforecast.data.entity.toEntity
import com.example.dailyforecast.data.source.local.database.DailyForecastDao
import com.example.dailyforecast.data.source.local.model.CityList
import com.example.dailyforecast.data.source.local.model.WeatherEntity
import com.example.dailyforecast.data.source.remote.network.DailyForecastService
import com.example.dailyforecast.data.utils.Constant
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Created by Aziza Helmy on 4/15/2024.
 */
class DailyForecastRepositoryImp(
    private val context: Application,
    private val dailyForecastService: DailyForecastService,
    private val diaDailyForecastLocalDb: DailyForecastDao
) :
    DailyForecastRepository {
    override suspend fun getCurrentWeather(lat: Double, long: Double): DailyForecast {
        return dailyForecastService.getCurrentWeather(lat, long).toEntity()
    }

    //todo:it's fake just for testing
    override suspend fun insertAllDailyForecastToDb(dailyForecast: WeatherEntity) {
        diaDailyForecastLocalDb.insertAllDailyForecastToDb(
            WeatherEntity(description = dailyForecast.description, icon = ""))
    }

    //todo:it's fake just for testing
    override suspend fun getAllDailyForecastFromDb(): WeatherEntity {
        return diaDailyForecastLocalDb.getAllDailyForecastFromDb()
    }

    override suspend fun getCities(): CityList {
        return parseJsonToModel(readJsonFromAssets(context, Constant.FILE_NAME))
    }

    private fun readJsonFromAssets(context: Context, fileName: String): String {
        return context.assets.open(fileName).bufferedReader().use { it.readText() }
    }

    private fun parseJsonToModel(jsonString: String): CityList {
        val gson = Gson()
        return gson.fromJson(jsonString, object : TypeToken<CityList>() {}.type)
    }
}