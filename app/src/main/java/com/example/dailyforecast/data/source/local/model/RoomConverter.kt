package com.example.dailyforecast.data.source.local.model

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.Collections

/**
 * Created by Aziza Helmy on 4/17/2024.
 */
class RoomConverter {

        @TypeConverter
        fun fromWeatherEntityList(value: List<WeatherEntity>?): String {
            if (value == null) {
                return ""
            }
            val gson = Gson()
            val type = object : TypeToken<List<WeatherEntity>>() {}.type
            return gson.toJson(value, type)
        }

        @TypeConverter
        fun toWeatherEntityList(value: String): List<WeatherEntity>? {
            if (value.isEmpty()) {
                return Collections.emptyList()
            }
            val gson = Gson()
            val type = object : TypeToken<List<WeatherEntity>>() {}.type
            return gson.fromJson(value, type)
        }


        @TypeConverter
        fun fromWeatherInfoEntity(value: WeatherInfoEntity?): String {
            if (value == null) {
                return ""
            }
            val gson = Gson()
            return gson.toJson(value)
        }

        @TypeConverter
        fun toWeatherInfoEntity(value: String): WeatherInfoEntity? {
            if (value.isEmpty()) {
                return null
            }
            val gson = Gson()
            return gson.fromJson(value, WeatherInfoEntity::class.java)
        }
    }
