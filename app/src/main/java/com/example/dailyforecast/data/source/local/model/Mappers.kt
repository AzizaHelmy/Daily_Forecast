package com.example.dailyforecast.data.source.local.model

import com.example.dailyforecast.data.entity.Weather
import com.example.dailyforecast.data.entity.WeatherInfo
import com.example.dailyforecast.data.entity.WeatherItem

/**
 * Created by Aziza Helmy on 4/18/2024.
 */
fun WeatherItemEntity.toEntity(): WeatherItem {
    return WeatherItem(
        main = main.toEntity(),
        weather = weather.map { it.toEntity() },
        cloud =cloud,
        windSpeed = windSpeed,
        dateText = dateText
    )
}

fun List<WeatherItemEntity>.toEntity(): List<WeatherItem> {
    return map { it.toEntity() }
}

fun WeatherInfoEntity.toEntity(): WeatherInfo {
    return WeatherInfo(
        temp = temp,
        feelsLike = feelsLike,
        tempMin = tempMin,
        tempMax = tempMax,
        pressure = pressure,
        seaLevel = seaLevel,
        grndLevel = grndLevel,
        humidity = humidity,
        tempKf = tempKf
    )
}

fun WeatherEntity.toEntity(): Weather {
    return Weather(
        id = id,
        description = description,
        icon = icon
    )
}


