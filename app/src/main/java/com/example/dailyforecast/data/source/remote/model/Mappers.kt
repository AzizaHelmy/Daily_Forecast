package com.example.dailyforecast.data.source.remote.model

import com.example.dailyforecast.data.entity.Weather
import com.example.dailyforecast.data.entity.WeatherInfo
import com.example.dailyforecast.data.entity.WeatherItem
import java.text.SimpleDateFormat
import java.util.Locale

/**
 * Created by Aziza Helmy on 4/18/2024.
 */

fun DailyForecastDto.toEntity(): List<WeatherItem> {
    val lat = city.location.lat
    val lon = city.location.lon
    return weatherList.map { it.toEntity(lat, lon) }
}
fun WeatherItemDto.toEntity(lat: Double, lon: Double): WeatherItem {
    return WeatherItem(
        weatherInfo = main.toEntity(),
        weather = weather.map { it.toEntity() },
        cloud = clouds.all,
        windSpeed = wind.speed,
        dateText = formatDate(dateText),
        lat = lat,
        lon = lon
    )
}
/**
 * format date from yyyy-MM-dd HH:mm:ss to yyyy-MM-dd
 */
fun formatDate(dateString: String): String {
    val format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
    val date = format.parse(dateString)
    val dayFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    return dayFormat.format(date)
}
fun WeatherInfoDto.toEntity(): WeatherInfo {
    return WeatherInfo(
        temperature = temp,
        feelsTemperature = feelsLike,
        minimTemperature = tempMin,
        maximumTemperature = tempMax,
        pressure = pressure,
        seaLevel = seaLevel,
        grandLevel = grndLevel,
        humidity = humidity,
        kelvinTemperature = tempKf
    )
}

fun WeatherDto.toEntity(): Weather {
    return Weather(
        id = id,
        description = description,
        icon = icon
    )
}
