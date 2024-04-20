package com.example.dailyforecast.di

import com.example.dailyforecast.data.source.local.database.DailyForecastDao
import com.example.dailyforecast.data.source.local.database.DailyForecastDataBase
import org.koin.dsl.module

/**
 * Created by Aziza Helmy on 4/20/2024.
 */


fun provideDao(dailyForecastDataBase: DailyForecastDataBase): DailyForecastDao =
    dailyForecastDataBase.getDailyForecastDao()


val dataBaseTestModule = module {
    single { provideDao(get()) }
}

