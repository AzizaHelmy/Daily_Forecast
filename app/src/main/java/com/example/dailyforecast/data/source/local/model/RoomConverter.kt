package com.example.dailyforecast.data.source.local.model

import androidx.room.TypeConverter
import com.google.gson.Gson

/**
 * Created by Aziza Helmy on 4/17/2024.
 */
class RoomConverter {
    @TypeConverter
    fun listOfDailyForecastToJson(value: List<DailyForecastEntity>): String = Gson().toJson(value)

    @TypeConverter
    fun gsonToDailyForecastList(value: String) =
        Gson().fromJson(value, Array<DailyForecastEntity>::class.java).toList()
}