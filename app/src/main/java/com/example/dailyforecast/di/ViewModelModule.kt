package com.example.dailyforecast.di

import com.example.dailyforecast.ui.screen.HomeViewModel
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

/**
 * Created by Aziza Helmy on 4/15/2024.
 */

val viewModelModule = module {
    singleOf(::HomeViewModel) { bind<HomeViewModel>() }
}