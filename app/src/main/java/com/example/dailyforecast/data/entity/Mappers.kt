package com.example.dailyforecast.data.entity

import com.example.dailyforecast.data.source.local.model.WeatherEntity
import com.example.dailyforecast.data.source.local.model.WeatherInfoEntity
import com.example.dailyforecast.data.source.local.model.WeatherItemEntity

/**
 * Created by Aziza Helmy on 4/18/2024.
 */
fun WeatherItem.toLocalEntity(): WeatherItemEntity {
    return WeatherItemEntity(
        main = main.toLocalEntity(),
        weather = weather.map { it.toLocalEntity() },
        cloud = cloud,
        windSpeed = windSpeed,
        dateText = dateText
    )
}
fun List<WeatherItem>.toLocalEntity(): List<WeatherItemEntity> {
    return map { it.toLocalEntity() }
}

fun WeatherInfo.toLocalEntity(): WeatherInfoEntity {
    return WeatherInfoEntity(
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

fun Weather.toLocalEntity(): WeatherEntity {
    return WeatherEntity(
        id = id,
        description = description,
        icon = icon
    )
}


