package com.example.dailyforecast.data.source.service

import com.example.dailyforecast.data.entity.City

/**
 * Created by Aziza Helmy on 4/21/2024.
 */
interface CityService {
    suspend fun getCities(): List<City>
}