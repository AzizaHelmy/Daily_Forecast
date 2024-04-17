package com.example.dailyforecast.data.source.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.dailyforecast.data.source.remote.modle.DailyForecastDto
import com.example.dailyforecast.data.source.remote.modle.WeatherDto
import com.example.dailyforecast.data.source.remote.modle.WeatherInfoDto
import com.example.dailyforecast.data.source.remote.modle.WeatherItemDto
import com.example.dailyforecast.data.source.remote.modle.WindDto

/**
 * Created by Aziza Helmy on 4/16/2024.
 */

//@Entity(tableName = "dailyForecast")
data class DailyForecastEntity(
    //  @PrimaryKey(autoGenerate = true) @NonNull
    val id: Int = 0,
    val weatherList: List<WeatherItemEntity>
)


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

@Entity(tableName = "weather")
data class WeatherEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int=0,
    val description: String,
    val icon: String
)

fun DailyForecastDto.toLocalEntity(): DailyForecastEntity {
    return DailyForecastEntity(
        weatherList = weatherList.toEntity()
    )
}

fun WeatherItemDto.toEntity(): WeatherItemEntity {
    return WeatherItemEntity(
        main = main.toEntity(),
        weather = weather.map { it.toLocalEntity() },
        clouds = CloudEntity(clouds.all),
        wind = wind.toEntity(),
        dateText = dateText
    )
}

fun List<WeatherItemDto>.toEntity(): List<WeatherItemEntity> {
    return map { it.toEntity() }
}

fun WeatherInfoDto.toEntity(): WeatherInfoEntity {
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

fun WeatherDto.toLocalEntity(): WeatherEntity {
    return WeatherEntity(
        id = id,
        description = description,
        icon = icon
    )
}

fun WindDto.toEntity(): WindEntity {
    return WindEntity(
        speed = speed
    )
}


