package com.example.dailyforecast.ui.screen

/**
 * Created by Aziza Helmy on 4/16/2024.
 */
data class HomeUiState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val showSnackBar: Boolean = false,
    val weatherItems: List<WeatherItemUiState> = emptyList(),
    val cities: List<CityUiState> = emptyList(),
    val selectedCity: String = ""
)
data class CityUiState(
    val id: Int = 0,
    val cityNameAr: String = "",
    val cityNameEn: String = "",
    val lat: Double = 0.0,
    val lon: Double = 0.0
)
data class WeatherItemUiState(
    val city: String = "",
    val weatherDescription: String = "",
    val temperature: String = "",
    val weatherIcon: Int = 0,
    val day: String = "",
    val windSpeed: String = ""
)
