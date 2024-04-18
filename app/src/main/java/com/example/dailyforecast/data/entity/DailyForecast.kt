package com.example.dailyforecast.data.entity

/**
 * Created by Aziza Helmy on 4/16/2024.
 */
data class WeatherItem(
    val main: WeatherInfo,
    val weather: List<Weather>,
    val cloud: Int,
    val windSpeed: Double,
    val dateText: String
)
data class WeatherInfo(
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
data class Weather(
    val id: Int,
    val description: String,
    val icon: String
)
