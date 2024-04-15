package com.example.dailyforecast.data.entity

import com.example.dailyforecast.data.source.remote.modle.DailyForecastDto
import com.example.dailyforecast.data.source.remote.modle.WeatherDto
import com.example.dailyforecast.data.source.remote.modle.WeatherInfoDto
import com.example.dailyforecast.data.source.remote.modle.WeatherItemDto
import com.example.dailyforecast.data.source.remote.modle.WindDto

/**
 * Created by Aziza Helmy on 4/16/2024.
 */

data class DailyForecast(
    val weatherList: List<WeatherItem>
)

data class WeatherItem(
    val main: WeatherInfo,
    val weather: List<Weather>,
    val clouds: Cloud,
    val wind: Wind,
    val dateText: String
)

data class WeatherInfo(
    val temp: Double,
    val feelsLike: Double,
    val tempMin: Double,
    val tempMax: Double,
    val pressure: Int,
    val seaLevel: Int,
    val grndLevel: Int,
    val humidity: Int,
    val tempKf: Double
)

data class Cloud(
    val all: Int
)

data class Wind(
    val speed: Double
)

data class Weather(
    val id: Int,
    val description: String,
    val icon: String
)

//=======================Mappers==================
fun DailyForecastDto.toEntity(): DailyForecast {
    return DailyForecast(
        weatherList = weatherList.toEntity()
    )
}

fun WeatherItemDto.toEntity(): WeatherItem {
    return WeatherItem(
        main = main.toEntity(),
        weather = weather.map { it.toEntity() },
        clouds = Cloud(clouds.all),
        wind = wind.toEntity(),
        dateText = dateText
    )
}

fun List<WeatherItemDto>.toEntity(): List<WeatherItem> {
    return map { it.toEntity() }
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

fun WindDto.toEntity(): Wind {
    return Wind(
        speed = speed
    )
}

