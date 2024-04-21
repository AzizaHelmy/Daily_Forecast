package com.example.dailyforecast.data.source.local.model

import com.example.dailyforecast.data.entity.City
import com.example.dailyforecast.data.entity.Weather
import com.example.dailyforecast.data.entity.WeatherInfo
import com.example.dailyforecast.data.entity.WeatherItem

/**
 * Created by Aziza Helmy on 4/18/2024.
 */
fun WeatherItemEntity.toEntity(): WeatherItem {
    return WeatherItem(
        weatherInfo = weatherInfo.toEntity(),
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

fun WeatherEntity.toEntity(): Weather {
    return Weather(
        id = id,
        description = description,
        icon = icon
    )
}
fun CityEntity.toEntity(): City {
    return City(
        id = id,
        cityNameAr = cityNameAr,
        cityNameEn = cityNameEn,
        lat = lat,
        lon = lon
    )
}
fun List<CityEntity>.toEntity(): List<City> {
    return map { it.toEntity() }
}


