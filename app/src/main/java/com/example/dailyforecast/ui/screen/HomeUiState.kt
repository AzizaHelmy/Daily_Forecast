package com.example.dailyforecast.ui.screen

/**
 * Created by Aziza Helmy on 4/16/2024.
 */
data class HomeUiState(
    val isLoading: Boolean = false,
    val error: String = "",
    val weatherItems: List<WeatherItemUiState> = emptyList()
)

data class WeatherItemUiState(
    val city: String = "",
    val weatherDescription: String = "",
    val temperature: String = "",
    val weatherIcon: Int = 0,
    val day: String = "",
    val windSpeed: String = ""
)
