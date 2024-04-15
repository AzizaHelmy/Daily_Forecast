package com.example.dailyforecast.ui.screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dailyforecast.data.entity.DailyForecast
import com.example.dailyforecast.data.repository.DailyForecastRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * Created by Aziza Helmy on 4/15/2024.
 */
class HomeViewModel(private val repository: DailyForecastRepository) : ViewModel() {

    private val _state = MutableStateFlow(HomeUiState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            getCurrentWeather(lat = 30.0444, long = 31.2357) //todo:fake
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

    private suspend fun getCurrentWeather(lat: Double, long: Double) {
        _state.update { it.copy(isLoading = true) }
        tryToExecute(
            function = { repository.getCurrentWeather(lat, long) },
            onSuccess = ::onGetCurrentWeatherSuccess,
            onError = ::onError
        )
    }

    private fun onGetCurrentWeatherSuccess(dailyForecast: DailyForecast) {
        Log.e("TAG", "onGetCurrentWeatherSuccess:$dailyForecast ")
        _state.update { uiState ->
            uiState.copy(
               weatherItems = dailyForecast.weatherList.toUiState()
            )
        }
    }

    private fun onError(error: String) {
        Log.e("TAG", "onError:$error ")
        _state.update { it.copy(isLoading = false, error = error) }
    }
}