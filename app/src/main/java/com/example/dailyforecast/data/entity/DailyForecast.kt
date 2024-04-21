package com.example.dailyforecast.data.entity

/**
 * Created by Aziza Helmy on 4/16/2024.
 */
data class WeatherItem(
    val weatherInfo: WeatherInfo,
    val weather: List<Weather>,
    val cloud: Int,
    val windSpeed: Double,
    val dateText: String
)
data class WeatherInfo(
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
data class Weather(
    val id: Int,
    val description: String,
    val icon: String
)
