package com.example.dailyforecast.di

import android.app.Application
import androidx.room.Room
import com.example.dailyforecast.data.source.local.database.DailyForecastDataBase
import org.koin.dsl.module

/**
 * Created by Aziza Helmy on 4/20/2024.
 */

/**
 * In-Memory Room Database definition
 */
fun provideDataBase(application: Application): DailyForecastDataBase =
    Room.inMemoryDatabaseBuilder(
        application,
        DailyForecastDataBase::class.java
    ).allowMainThreadQueries()
        .build()


val dataBaseTestModule = module {
    single { provideDataBase(get()) }
}

