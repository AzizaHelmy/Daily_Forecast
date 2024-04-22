package com.example.dailyforecast.data.entity

import com.example.dailyforecast.data.source.local.model.WeatherEntity
import com.example.dailyforecast.data.source.local.model.WeatherInfoEntity
import com.example.dailyforecast.data.source.local.model.WeatherItemEntity

/**
 * Created by Aziza Helmy on 4/18/2024.
 */
fun WeatherItem.toLocalEntity(): WeatherItemEntity {
    return WeatherItemEntity(
        weatherInfo = weatherInfo.toLocalEntity(),
        weather = weather.map { it.toLocalEntity() },
        cloud = cloud,
        windSpeed = windSpeed,
        dateText = dateText,
        lat = lat,
        lon = lon
    )
}
fun List<WeatherItem>.toLocalEntity(): List<WeatherItemEntity> {
    return map { it.toLocalEntity() }
}

fun WeatherInfo.toLocalEntity(): WeatherInfoEntity {
    return WeatherInfoEntity(
        temperature = temperature,
        feelsTemperature = feelsTemperature,
        minimTemperature = minimTemperature,
        maximumTemperature = maximumTemperature,
        pressure = pressure,
        seaLevel = seaLevel,
        grandLevel = grandLevel,
        humidity = humidity,
        kelvinTemperature = kelvinTemperature
    )
}

fun Weather.toLocalEntity(): WeatherEntity {
    return WeatherEntity(
        id = id,
        description = description,
        icon = icon
    )
}



