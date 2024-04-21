package com.example.dailyforecast.ui.screen

import com.example.dailyforecast.data.entity.City
import com.example.dailyforecast.data.repository.DailyForecastRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.AfterAllCallback
import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.extension.ExtensionContext

/**
 * Created by Aziza Helmy on 4/20/2024.
 */
@ExperimentalCoroutinesApi
class TestDispatcherExtension : AfterAllCallback, BeforeAllCallback {
    override fun afterAll(context: ExtensionContext?) {
        Dispatchers.resetMain()
    }

    override fun beforeAll(context: ExtensionContext?) {
        Dispatchers.setMain(UnconfinedTestDispatcher())
    }
}

@ExtendWith(TestDispatcherExtension::class)
class HomeViewModelTest {

    private lateinit var repository: DailyForecastRepository
    private lateinit var viewModel: HomeViewModel

    @BeforeEach
    fun setup() {
        repository = mockk()
        viewModel = HomeViewModel(repository)
        // Mock getCities() method
        coEvery { repository.getCities() } returns listOf(
            City(1, "City1Ar", "City1En", 0.0, 0.0),
            City(2, "City2Ar", "City2En", 0.0, 0.0)
        )
    }

    @Test
    fun `getCities success`() = runBlocking {
        //GIVEN-
        val cities = listOf(
                City(1, "City1Ar", "City1En", 0.0, 0.0),
                City(2, "City2Ar", "City2En", 0.0, 0.0)
        )
        coEvery { repository.getCities() } returns cities
        //WHEN-
        viewModel.getCities()
        //THEN-
        assertEquals(cities, viewModel.state.value.cities)
    }

    @Test
    fun `getCurrentWeather success`() = runBlocking {
        //GIVEN- current weather from repository

        //WHEN- get the current weather from the view model

        //THEN- will return list of weather items
        //assertEquals(weatherItems, viewModel.state.value.weatherItems)
    }

}