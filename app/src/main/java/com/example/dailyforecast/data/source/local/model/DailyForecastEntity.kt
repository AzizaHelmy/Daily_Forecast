package com.example.dailyforecast.data.source.local.model

import androidx.room.Entity
import com.example.dailyforecast.data.entity.Cloud
import com.example.dailyforecast.data.entity.DailyForecast
import com.example.dailyforecast.data.entity.Weather
import com.example.dailyforecast.data.entity.WeatherInfo
import com.example.dailyforecast.data.entity.WeatherItem
import com.example.dailyforecast.data.entity.Wind

/**
 * Created by Aziza Helmy on 4/16/2024.
 */

@Entity(tableName = "dailyForecast")
data class DailyForecastEntity(val weatherList: List<WeatherItemEntity>)


data class WeatherItemEntity(
    val main: WeatherInfoEntity,
    val weather: List<WeatherEntity>,
    val clouds: CloudEntity,
    val wind: WindEntity,
    val dateText: String
)

data class WeatherInfoEntity(
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

data class CloudEntity(
    val all: Int
)

data class WindEntity(
    val speed: Double
)

data class WeatherEntity(
    val id: Int,
    val description: String,
    val icon: String
)

fun DailyForecastEntity.toEntity(): DailyForecast {
    return DailyForecast(
        weatherList = weatherList.toEntity()
    )
}

fun WeatherItemEntity.toEntity(): WeatherItem {
    return WeatherItem(
        main = main.toEntity(),
        weather = weather.map { it.toEntity() },
        clouds = Cloud(clouds.all),
        wind = wind.toEntity(),
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

fun WindEntity.toEntity(): Wind {
    return Wind(
        speed = speed
    )
}


