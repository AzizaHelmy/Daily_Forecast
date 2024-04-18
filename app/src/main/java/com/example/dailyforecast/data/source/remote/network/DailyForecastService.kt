package com.example.dailyforecast.data.source.remote.network

import com.example.dailyforecast.BuildConfig
import com.example.dailyforecast.data.source.remote.modle.DailyForecastDto
import com.example.dailyforecast.data.source.remote.modle.WeatherItemDto
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Aziza Helmy on 4/15/2024.
 */
interface DailyForecastService {
    @GET("data/2.5/forecast?")
    suspend fun getCurrentWeather(
        @Query("lat") lat: Double,
        @Query("lon") long: Double,
        @Query("appid") appId: String =  BuildConfig.API_KEY
    ):List<WeatherItemDto>
}