package com.example.dailyforecast.data.repository

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.runner.AndroidJUnit4
import com.example.dailyforecast.data.source.local.database.DailyForecastDao
import com.example.dailyforecast.data.source.remote.network.DailyForecastService
import com.example.dailyforecast.di.dataBaseTestModule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith
import org.koin.core.context.GlobalContext.stopKoin
import org.koin.core.context.loadKoinModules
import org.koin.test.KoinTest
import org.koin.test.inject

/**
 * Created by Aziza Helmy on 4/20/2024.
 */
@RunWith(AndroidJUnit4::class)
@ExperimentalCoroutinesApi
class DailyForecastRepositoryImpTest : KoinTest {

    private lateinit var context: Context
    private val dailyForecastService: DailyForecastService by inject()
    private val diaDailyForecastLocalDb: DailyForecastDao by inject()

    @Before
    fun setUp() {
        context = ApplicationProvider.getApplicationContext()
        loadKoinModules(dataBaseTestModule)
    }
    @After
    fun tearDown() {
        stopKoin()
    }



}