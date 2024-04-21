package com.example.dailyforecast.ui.screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dailyforecast.data.entity.City
import com.example.dailyforecast.data.entity.WeatherItem
import com.example.dailyforecast.data.repository.DailyForecastRepository
import com.example.dailyforecast.data.utils.DailyForecastState
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
        getCities()
        getDailyForecast(lat = 30.0444, long = 31.2357) //todo:later ISA
    }


     fun getCities() {
        _state.update { it.copy(isLoading = true, isError = false) }
        tryToExecute(
            function = { repository.getCities() },
            onSuccess = ::onGetCitiesSuccess,
            onError = ::onError
        )
    }

    private fun getDailyForecast(lat: Double, long: Double) {
        _state.update { it.copy(isLoading = true, isError = false) }
        tryToExecute(
            function = { repository.getDailyForecast(lat, long) },
            onSuccess = ::onGetAllDailyForecastSuccess,
            onError = ::onError
        )
    }

    private fun onGetAllDailyForecastSuccess(weather: Pair<List<WeatherItem>, DailyForecastState>) {
        val (dailyForecast, source) = weather
        when (source) {
            DailyForecastState.NETWORK -> {
                _state.update {
                    it.copy(
                        showSnackBar = false,
                        weatherItems = dailyForecast.toUiState(),
                        isLoading = false,
                        isError = false
                    )
                }
            }

            DailyForecastState.DATABASE -> {
                if (dailyForecast.isNotEmpty()) {
                    _state.update {
                        it.copy(
                            isLoading = false,
                            isError = false,
                            showSnackBar = true,
                            weatherItems = dailyForecast.toUiState()
                        )
                    }

                } else {
                    _state.update {
                        it.copy(
                            isLoading = false,
                            isError = true,
                            showSnackBar = false,
                            weatherItems = emptyList()
                        )
                    }
                }
            }
        }
    }

    private fun onGetCitiesSuccess(cities: List<City>) {
        _state.update { uiState ->
            uiState.copy(
                isLoading = false,
                cities = cities.map { it.toUiState() },
                selectedCity = cities.first().cityNameEn
            )
        }
    }

    private fun onError(error: String) {
        Log.e("TAG", "onError:$error ")
        _state.update { it.copy(isLoading = false, isError = true, showSnackBar = false) }
    }

    override fun onCitySelected(lat: Double, long: Double, cityName: String) {
            getDailyForecast(lat = lat, long = long)
            _state.update { it.copy(selectedCity = cityName) }
    }

    override fun onRetryClicked() {
        _state.update { it.copy(isLoading = true) }
            getDailyForecast(lat = 30.0444, long = 31.2357) //todo:later ISA
    }

    /**
     * This function is used to execute a suspend function and handle the success and error cases
     */
    private fun <T> tryToExecute(
        function: suspend () -> T,
        onSuccess: (T) -> Unit,
        onError: (String) -> Unit,
    ) {
        try {
            viewModelScope.launch(Dispatchers.IO) {
                val result = function()
                onSuccess(result)
            }
        } catch (e: Exception) {
            onError(e.message.toString())
        }
    }
}