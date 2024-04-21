package com.example.dailyforecast.data.source.service

import android.content.Context
import com.example.dailyforecast.data.entity.City
import com.example.dailyforecast.data.source.local.model.Cities
import com.example.dailyforecast.data.source.local.model.toEntity
import com.example.dailyforecast.data.utils.Constant
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Created by Aziza Helmy on 4/21/2024.
 */
class CityServiceImp(private val context: Context) : CityService {
    override suspend fun getCities(): List<City> {
        return parseJsonToModel(
            readJsonFromAssets(
                context,
                Constant.FILE_NAME
            )
        ).cities.map { it.toEntity() }
    }

    private fun readJsonFromAssets(context: Context, fileName: String): String {
        return context.assets.open(fileName).bufferedReader().use { it.readText() }
    }

    private fun parseJsonToModel(jsonString: String): Cities {
        val gson = Gson()
        return gson.fromJson(jsonString, object : TypeToken<Cities>() {}.type)
    }

}