package com.example.dailyforecast.di

import android.app.Application
import androidx.room.Room
import com.example.dailyforecast.data.source.local.database.DailyForecastDao
import com.example.dailyforecast.data.source.local.database.DailyForecastDataBase
import com.example.dailyforecast.data.utils.Constant
import org.koin.dsl.module

/**
 * Created by Aziza Helmy on 4/15/2024.
 */
fun provideDataBase(application: Application): DailyForecastDataBase =
    Room.databaseBuilder(
        application,
        DailyForecastDataBase::class.java,
        Constant.DATABASE_NAME
    ).fallbackToDestructiveMigration().build()

fun provideDao(dailyForecastDataBase: DailyForecastDataBase): DailyForecastDao =
    dailyForecastDataBase.getDailyForecastDao()


val dataBaseModule = module {
    single { provideDataBase(get()) }
    single { provideDao(get()) }
}