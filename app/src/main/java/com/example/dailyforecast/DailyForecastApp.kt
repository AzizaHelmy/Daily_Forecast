package com.example.dailyforecast

import android.app.Application
import com.example.dailyforecast.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

/**
 * Created by Aziza Helmy on 4/15/2024.
 */
class DailyForecastApp: Application(){
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@DailyForecastApp)
            modules(appModule())
        }
    }
}