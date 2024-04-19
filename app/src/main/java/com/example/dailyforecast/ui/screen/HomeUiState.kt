package com.example.dailyforecast.ui.screen

import com.example.dailyforecast.data.source.local.model.CityEntity

/**
 * Created by Aziza Helmy on 4/16/2024.
 */
data class HomeUiState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val showSnackBar: Boolean = false,
    val weatherItems: List<WeatherItemUiState> = emptyList(),
    val cities: List<CityEntity> = emptyList()
)

data class WeatherItemUiState(
    val city: String = "",
    val weatherDescription: String = "",
    val temperature: String = "",
    val weatherIcon: Int = 0,
    val day: String = "",
    val windSpeed: String = ""
)
