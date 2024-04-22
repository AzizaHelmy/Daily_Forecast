package com.example.dailyforecast.data.source.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Aziza Helmy on 4/16/2024.
 */

@Entity(tableName = "dailyForecast")
data class WeatherItemEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val weatherInfo: WeatherInfoEntity,
    val weather: List<WeatherEntity>,
    val cloud: Int,
    val windSpeed: Double,
    val dateText: String,
    val lat: Double,
    val lon: Double
)

data class WeatherInfoEntity(
    val temperature: Double,
    val feelsTemperature: Double,
    val minimTemperature: Double,
    val maximumTemperature: Double,
    val pressure: Int,
    val seaLevel: Int,
    val grandLevel: Int,
    val humidity: Int,
    val kelvinTemperature: Double
)

data class WeatherEntity(
    val id: Int = 0,
    val description: String,
    val icon: String
)

