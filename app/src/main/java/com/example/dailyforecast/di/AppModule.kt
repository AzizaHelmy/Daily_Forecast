package com.example.dailyforecast.di

import org.koin.dsl.module

/**
 * Created by Aziza Helmy on 4/15/2024.
 */

fun appModule() = module {
    includes(
        networkModule,
        dataBaseModule,
        repositoryModule,
        viewModelModule
    )
}