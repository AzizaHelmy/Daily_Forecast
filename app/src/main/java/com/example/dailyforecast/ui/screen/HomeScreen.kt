package com.example.dailyforecast.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dailyforecast.R
import com.example.dailyforecast.ui.screen.compsable.DropDown
import com.example.dailyforecast.ui.screen.compsable.ErrorAndRetry
import com.example.dailyforecast.ui.screen.compsable.SnackBar
import com.example.dailyforecast.ui.screen.compsable.WeatherItem
import org.koin.compose.koinInject


/**
 * Created by Aziza Helmy on 4/15/2024.
 */
@Composable
fun HomeScreen(viewModel: HomeViewModel = koinInject()) {
    val state by viewModel.state.collectAsState()
    HomeContent(state = state, listener = viewModel)
}

@Composable
private fun HomeContent(state: HomeUiState, listener: HomeInteractionListener) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF2F2F2)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ) {
            DropDown(state, listener)
            if (state.isError) ErrorAndRetry(listener = listener)
            LazyColumn(
                contentPadding = PaddingValues(
                    horizontal = 16.dp,
                    vertical = 4.dp
                )
            ) {
                if (state.isLoading) {
                    item {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(440.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator()
                        }
                    }
                } else {
                    itemsIndexed(items = state.weatherItems) { _, user ->
                        WeatherItem(user)
                    }
                }
            }
        }
        SnackBar(
            icon = painterResource(R.drawable.ic_android),
            isVisible = state.showSnackBar,
            modifier = Modifier
                .padding(bottom = 16.dp)
                .align(Alignment.BottomCenter)
        ) {
            Text(
                text = " it’s not accurate data !",
            )
        }
    }
}


@Preview
@Composable
fun PreviewWeatherItem() {
    WeatherItem(
        state = WeatherItemUiState(
            temperature = "40",
            weatherDescription = "Clear Sky",
            weatherIcon = 0
        )
    )
}