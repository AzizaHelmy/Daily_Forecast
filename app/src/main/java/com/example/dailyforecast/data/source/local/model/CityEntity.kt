package com.example.dailyforecast.data.source.local.model

/**
 * Created by Aziza Helmy on 4/16/2024.
 */
data class Cities(
    val cities: List<CityEntity>
)
data class CityEntity(
    val id: Int,
    val cityNameAr: String,
    val cityNameEn: String,
    val lat: Double,
    val lon: Double
)