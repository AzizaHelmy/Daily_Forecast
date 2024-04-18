package com.example.dailyforecast.ui.screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dailyforecast.data.entity.Weather
import com.example.dailyforecast.data.entity.WeatherInfo
import com.example.dailyforecast.data.entity.WeatherItem
import com.example.dailyforecast.data.repository.DailyForecastRepository
import com.example.dailyforecast.data.source.local.model.CityList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * Created by Aziza Helmy on 4/15/2024.
 */
class HomeViewModel(private val repository: DailyForecastRepository) : ViewModel(),
    HomeInteractionListener {

    private val _state = MutableStateFlow(HomeUiState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            getDB() //todo: fake for testing room if it works ok
            getCities()
            getCurrentWeather(lat = 30.0444, long = 31.2357) //todo:later ISA
        }
    }

    private suspend fun <T> tryToExecute(
        function: suspend () -> T,
        onSuccess: suspend (T) -> Unit,
        onError: (String) -> Unit,
    ) {
        try {
            val result = function()
            onSuccess(result)
        } catch (e: Exception) {
            onError(e.message.toString())
        }
    }


    private suspend fun getCities() {
        _state.update { it.copy(isLoading = true) }
        tryToExecute(
            function = { repository.getCities() },
            onSuccess = ::onGetCitiesSuccess,
            onError = ::onError
        )
    }
    //todo: fake for testing room if it works ok
    private suspend fun getDB() {
        viewModelScope.launch {
          repository.insertAllDailyForecastToDb(
              listOf(
                  WeatherItem(
                      main = WeatherInfo(
                          temp = 30.0,
                          feelsLike = 30.0,
                          tempMin = 30.0,
                          tempMax = 30.0,
                          pressure = 30,
                          seaLevel = 30,
                          grndLevel = 30,
                          humidity = 30,
                          tempKf = 30.0
                      ),
                      weather = listOf(
                          Weather(
                              id = 0,
                              description = "description",
                              icon = "icon"
                          )
                      ),
                      dateText = "dateText",
                      cloud = 0,
                      windSpeed = 0.0
                  )
              )
          )
            repository.getAllDailyForecastFromDb()
            Log.e("TAG", "getDB:${  repository.getAllDailyForecastFromDb()} ", )
        }
    }

    private suspend fun getCurrentWeather(lat: Double, long: Double) {
        _state.update { it.copy(isLoading = true) }
        tryToExecute(
            function = { repository.getCurrentWeather(lat, long) },
            onSuccess = ::onGetCurrentWeatherSuccess,
            onError = ::onError
        )
    }

    private fun onGetCurrentWeatherSuccess(dailyForecast: List<WeatherItem>){
        _state.update { uiState ->
            uiState.copy(
                isLoading = false,
                weatherItems = dailyForecast.toUiState()
            )
        }
    }

    private fun onGetCitiesSuccess(cities: CityList) {
        _state.update { uiState ->
            uiState.copy(
                isLoading = false,
                cities = cities.cities
            )
        }
    }

    private fun onError(error: String) {
        Log.e("TAG", "onError:$error ")
        _state.update { it.copy(isLoading = false, error = error) }
    }

    override fun onCitySelected(lat: Double, long: Double) {
        viewModelScope.launch {
            Log.e("TAG", "onCitySelected:$lat == $long")
            getCurrentWeather(lat = lat, long = long)
        }
    }
}