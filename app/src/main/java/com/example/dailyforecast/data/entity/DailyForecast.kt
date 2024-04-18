package com.example.dailyforecast.data.entity

import com.example.dailyforecast.data.source.local.model.DailyForecastEntity
import com.example.dailyforecast.data.source.local.model.WeatherEntity
import com.example.dailyforecast.data.source.local.model.WeatherInfoEntity
import com.example.dailyforecast.data.source.local.model.WeatherItemEntity
import com.example.dailyforecast.data.source.remote.modle.DailyForecastDto
import com.example.dailyforecast.data.source.remote.modle.WeatherDto
import com.example.dailyforecast.data.source.remote.modle.WeatherInfoDto
import com.example.dailyforecast.data.source.remote.modle.WeatherItemDto

/**
 * Created by Aziza Helmy on 4/16/2024.
 */
data class WeatherItem(
    val main: WeatherInfo,
    val weather: List<Weather>,
    val cloud: Int,
    val windSpeed: Double,
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
data class Weather(
    val id: Int,
    val description: String,
    val icon: String
)

//=======================Mappers==================
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


    //=======================Mappers==================
    fun DailyForecastEntity.toModel(): List<WeatherItem> {
        return weatherList.map { it.toEntity() }
    }

    fun WeatherItemEntity.toEntity(): WeatherItem {
        return WeatherItem(
            main = main.toModel(),
            weather = weather.map { it.toModel() },
            cloud =cloud,
            windSpeed = windSpeed,
            dateText = dateText
        )
    }

    fun List<WeatherItemEntity>.toModel(): List<WeatherItem> {
        return map { it.toEntity() }
    }

    fun WeatherInfoEntity.toModel(): WeatherInfo {
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

    fun WeatherEntity.toModel(): Weather {
        return Weather(
            id = id,
            description = description,
            icon = icon
        )
    }


