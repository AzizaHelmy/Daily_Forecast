package com.example.dailyforecast.data.repository

import android.app.Application
import android.content.Context
import com.example.dailyforecast.data.entity.WeatherItem
import com.example.dailyforecast.data.entity.toLocalEntity
import com.example.dailyforecast.data.source.local.database.DailyForecastDao
import com.example.dailyforecast.data.source.local.model.CityList
import com.example.dailyforecast.data.source.local.model.toEntity
import com.example.dailyforecast.data.source.remote.modle.toEntity
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

    override suspend fun getWeatherFromRemote(lat: Double, long: Double): List<WeatherItem> {
        return dailyForecastService.getCurrentWeather(lat, long).toEntity()
    }

    override suspend fun insertAllDailyForecastToDb(dailyForecast: List<WeatherItem>) {
        diaDailyForecastLocalDb.insertAllDailyForecastToDb(
            dailyForecast.toLocalEntity()
        )
    }

    override suspend fun getAllDailyForecastFromDb(): List<WeatherItem> {
        return diaDailyForecastLocalDb.getAllDailyForecastFromDb().toEntity()
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