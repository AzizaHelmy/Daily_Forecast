package com.example.dailyforecast.di

import com.example.dailyforecast.data.repository.DailyForecastRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

/**
 * Created by Aziza Helmy on 4/15/2024.
 */
val repositoryModule = module {
    singleOf(::DailyForecastRepositoryImpl) { bind<DailyForecastRepository>() }
}