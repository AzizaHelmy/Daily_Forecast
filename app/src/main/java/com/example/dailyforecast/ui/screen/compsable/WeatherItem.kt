package com.example.dailyforecast.ui.screen.compsable


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.dailyforecast.ui.screen.WeatherItemUiState

/**
 * Created by Aziza Helmy on 4/19/2024.
 */
@Composable
fun WeatherItem(state: WeatherItemUiState) {
    Card(
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier
            .padding(8.dp)
    ) {

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = rememberAsyncImagePainter(model = state.weatherIcon),
                contentDescription = "",
                modifier = Modifier
                    .padding(16.dp)
                    .size(20.dp)
                    .clip(
                        shape = RoundedCornerShape(
                            topStart = 16.dp,
                            topEnd = 0.dp,
                            bottomStart = 16.dp,
                            bottomEnd = 16.dp
                        )
                    )
            )
            Text(
                text = state.temperature,
                modifier = Modifier
                    .padding(8.dp)
            )

            Text(
                text = state.weatherDescription,
                modifier = Modifier.padding(top = 4.dp, bottom = 8.dp)
            )
        }
    }
}