package com.example.dailyforecast.data.source.local.database

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.example.dailyforecast.data.source.local.model.WeatherEntity
import com.example.dailyforecast.data.source.local.model.WeatherInfoEntity
import com.example.dailyforecast.data.source.local.model.WeatherItemEntity
import com.example.dailyforecast.di.dataBaseTestModule
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.loadKoinModules
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject

/**
 * Created by Aziza Helmy on 4/19/2024.
 */
@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
//Unit test the DAO
@SmallTest
class DailyForecastDaoTest : KoinTest {

    private val weatherDatabase: DailyForecastDataBase by inject()
    private val weatherDAO: DailyForecastDao by inject()

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    /**
     * Override default Koin configuration to use Room in-memory database
     */
    @Before
    fun createDb() {
        loadKoinModules(dataBaseTestModule)
    }

    /**
     * Close resources
     */
    @After
    fun after() {
        weatherDatabase.close()
        stopKoin()
    }

    @Test
    fun `shouldReturnAllDailyForecastWhenInsertItInDB`() = runBlocking {
        //GIVEN- saving a dailyForecast
        val dailyForecast = listOf(
            WeatherItemEntity(
                1,
                WeatherInfoEntity(1.0, 1.0, 1.0, 1.0, 1, 1, 1, 1, 1.0),
                listOf(WeatherEntity(1, "description1", "icon1")),
                1,
                1.0,
                "dateText1"
            ),
        )
        weatherDAO.insertAllDailyForecastToDb(dailyForecast)
        //WHEN- getting the data from db
        val result = weatherDAO.getAllDailyForecastFromDb()
        //THEN- will return it
        assertEquals(dailyForecast, result)
    }

}
