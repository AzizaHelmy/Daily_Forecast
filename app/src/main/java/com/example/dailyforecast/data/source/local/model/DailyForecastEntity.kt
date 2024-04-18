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
    val main: WeatherInfoEntity,
    val weather: List<WeatherEntity>,
    val cloud: Int,
    val windSpeed: Double,
    val dateText: String
)

data class WeatherInfoEntity(
    val temp: Double,
    val feelsLike: Double,
    val tempMin: Double,
    val tempMax: Double,
    val pressure: Int,
    val seaLevel: Int,
    val grndLevel: Int,
    val humidity: Int,
    val tempKf: Double
)

data class WeatherEntity(
    val id: Int = 0,
    val description: String,
    val icon: String
)

