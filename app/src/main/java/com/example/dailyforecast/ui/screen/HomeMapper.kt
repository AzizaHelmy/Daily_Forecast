package com.example.dailyforecast.ui.screen

import com.example.dailyforecast.data.entity.DailyForecast
import com.example.dailyforecast.data.entity.WeatherItem

/**
 * Created by Aziza Helmy on 4/16/2024.
 */
fun DailyForecast.toUiState(): HomeUiState {
    return HomeUiState(weatherItems = weatherList.toUiState())
}

fun List<WeatherItem>.toUiState(): List<WeatherItemUiState> {
    return this.map { weatherItem ->
        WeatherItemUiState(
            weatherDescription = weatherItem.weather.firstOrNull()?.description ?: "",
            temperature = "${weatherItem.main.temp}°C", // Assuming temperature is in Celsius
            weatherIcon = 0, // You can map weather icon here if needed
            day = weatherItem.dateText, // Assuming dateText represents the day
            windSpeed = "${weatherItem.wind.speed} m/s" // Assuming wind speed is in meters per second
        )
    }
}