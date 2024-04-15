package com.example.dailyforecast.data.source.remote.network

import com.example.dailyforecast.data.source.remote.modle.DailyForecastDto
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
        @Query("appid") appid: String = "416c3f7d60f73a4f8f76c658c93cf3b7" //todo: change later
    ):DailyForecastDto
}