package com.example.dailyforecast.data.source.local.model

import androidx.annotation.NonNull
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import com.example.dailyforecast.data.entity.Weather
import com.example.dailyforecast.data.entity.WeatherInfo
import com.example.dailyforecast.data.entity.WeatherItem

/**
 * Created by Aziza Helmy on 4/16/2024.
 */

@Entity(tableName = "dailyForecast")
data class DailyForecastEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val weatherList: List<WeatherItemEntity>
)
data class DailyForecastWithWeatherItems(
    @Embedded
    val dailyForecast: DailyForecastEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "forecastId"
    )
    val weatherItems: List<WeatherItemEntity>
)
data class WeatherItemEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val forecastId: Int, // new field
    val main: WeatherInfoEntity,
    val weather: List<WeatherEntity>,
    val cloud: Int,
    val windSpeed: Double,
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


//@Entity(tableName = "weather")
data class WeatherEntity(
   // @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val description: String,
    val icon: String
)

fun List<WeatherItem>.toLocalEntity(): List<WeatherItemEntity> {
    return map { it.toEntity() }
}

fun WeatherItem.toEntity(): WeatherItemEntity {
    return WeatherItemEntity(
        main = main.toEntity(),
        weather = weather.map { it.toLocalEntity() },
        cloud = cloud,
        windSpeed = windSpeed,
        dateText = dateText
    )
}

fun List<WeatherItem>.toEntity(): List<WeatherItemEntity> {
    return map { it.toEntity() }
}

fun WeatherInfo.toEntity(): WeatherInfoEntity {
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


