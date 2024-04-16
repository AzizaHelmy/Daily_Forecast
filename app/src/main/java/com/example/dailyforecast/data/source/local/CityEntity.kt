package com.example.dailyforecast.data.source.local

/**
 * Created by Aziza Helmy on 4/16/2024.
 */
data class CityList(
    val cities: List<City>
)
data class City(
    val id: Int,
    val cityNameAr: String,
    val cityNameEn: String,
    val lat: Double,
    val lon: Double
)