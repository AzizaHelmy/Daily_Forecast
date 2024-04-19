package com.example.dailyforecast.data.source.remote.modle

import com.example.dailyforecast.data.entity.Weather
import com.example.dailyforecast.data.entity.WeatherInfo
import com.example.dailyforecast.data.entity.WeatherItem

/**
 * Created by Aziza Helmy on 4/18/2024.
 */

fun DailyForecastDto.toEntity(): List<WeatherItem> {
    return weatherList.map { it.toEntity() }
}

fun WeatherItemDto.toEntity(): WeatherItem {
    return WeatherItem(
        main = main.toEntity(),
        weather = weather.map { it.toEntity() },
        cloud = clouds.all,
        windSpeed = wind.speed,
        dateText = dateText
    )
}
fun WeatherInfoDto.toEntity(): WeatherInfo {
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

fun WeatherDto.toEntity(): Weather {
    return Weather(
        id = id,
        description = description,
        icon = icon
    )
}
