package com.example.dailyforecast.di

import com.example.dailyforecast.data.source.service.CityService
import com.example.dailyforecast.data.source.service.CityServiceImp
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

/**
 * Created by Aziza Helmy on 4/21/2024.
 */
val serviceModule = module {
    singleOf(::CityServiceImp) { bind<CityService>() }
}