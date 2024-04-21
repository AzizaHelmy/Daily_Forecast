package com.example.dailyforecast.ui.screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dailyforecast.data.entity.City
import com.example.dailyforecast.data.entity.WeatherItem
import com.example.dailyforecast.data.repository.DailyForecastRepository
import kotlinx.coroutines.Dispatchers
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
            getCities()
            getAllDailyForecast(lat = 30.0444, long = 31.2357) //todo:later ISA
        }
    }

    private suspend fun <T> tryToExecute(
        function: suspend () -> T,
        onSuccess: suspend (T) -> Unit,
        onError: suspend (String) -> Unit,
        shouldLaunchInIODispatcher: Boolean = false
    ) {
        try {
            if (shouldLaunchInIODispatcher) {
                viewModelScope.launch(Dispatchers.IO) {
                    val result = function()
                    onSuccess(result)
                }
            } else {
                val result = function()
                onSuccess(result)
            }
        } catch (e: Exception) {
            onError(e.message.toString())
        }
    }

    private suspend fun getCities() {
        _state.update { it.copy(isLoading = true,isError = false) }
        tryToExecute(
            function = { repository.getCities() },
            onSuccess = ::onGetCitiesSuccess,
            onError = ::onError
        )
    }

    private suspend fun getAllDailyForecast(lat: Double, long: Double) {
        _state.update { it.copy(isLoading = true, isError = false) }
        tryToExecute(
            function = { repository.getDailyForecastFromNetwork(lat, long) },
            onSuccess = { dailyForecast ->
                _state.update { it.copy(showSnackBar = false) }
                repository.insertAllDailyForecastToLocal(dailyForecast)
                Log.e("TAG", "getCurrentWeather:yes remote ")
                onGetAllDailyForecastSuccess(dailyForecast)
            },
            onError = {
                tryToExecute(
                    shouldLaunchInIODispatcher = true,
                    function = { repository.getAllDailyForecastFromLocal() },
                    onSuccess = { weatherItems ->
                        Log.e("TAG", "getCurrentWeather:yes Local ")
                        _state.update { it.copy(showSnackBar = true) }
                        onGetAllDailyForecastSuccess(weatherItems)
                    },
                    onError = ::onError
                )
            }
        )
    }

    private fun onGetAllDailyForecastSuccess(dailyForecast: List<WeatherItem>) {
        if (dailyForecast.isNotEmpty()) {
            _state.update { uiState ->
                uiState.copy(
                    isLoading = false,
                    weatherItems = dailyForecast.toUiState()
                )
            }
        } else {
            _state.update { it.copy(isLoading = false, isError = true, showSnackBar = false) }
        }
    }

    private fun onGetCitiesSuccess(cities: List<City>) {
        _state.update { uiState ->
            uiState.copy(
                isLoading = false,
                cities = cities.map { it.toUiState() }
            )
        }
    }

    private fun onError(error: String) {
        Log.e("TAG", "onError:$error ")
        _state.update { it.copy(isLoading = false, isError = true, showSnackBar = false) }
    }

    override fun onCitySelected(lat: Double, long: Double) {
        viewModelScope.launch {
            getAllDailyForecast(lat = lat, long = long)
        }
    }

    override fun onRetryClicked() {
        _state.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            getAllDailyForecast(lat = 30.0444, long = 31.2357) //todo:later ISA
        }
    }
}