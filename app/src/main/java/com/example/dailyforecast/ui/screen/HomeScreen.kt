package com.example.dailyforecast.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import org.koin.compose.koinInject


/**
 * Created by Aziza Helmy on 4/15/2024.
 */
@Composable
fun HomeScreen(viewModel: HomeViewModel = koinInject()) {
    val state by viewModel.state.collectAsState()
    HomeContent(state = state)
}

@Composable
private fun HomeContent(state: HomeUiState) {

}

@Composable
fun WeatherItem(state: WeatherItemUiState) {
    Card(
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {

        Column(verticalArrangement = Arrangement.Center) {
            Image(
                painter = rememberAsyncImagePainter(model = state.weatherIcon),
                contentDescription = "",
                modifier = Modifier
                    .padding(16.dp)
                    .size(50.dp)
                    .clip(
                        shape = RoundedCornerShape(
                            topStart = 16.dp,
                            topEnd = 0.dp,
                            bottomStart = 16.dp,
                            bottomEnd = 16.dp
                        )
                    )
            )
            Text(text = state.temperature, modifier = Modifier.padding(bottom = 4.dp))

            Text(text = state.weatherDescription)
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