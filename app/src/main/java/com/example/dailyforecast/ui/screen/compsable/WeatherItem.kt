package com.example.dailyforecast.ui.screen.compsable


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.dailyforecast.R
import com.example.dailyforecast.ui.screen.WeatherItemUiState
import com.example.dailyforecast.ui.theme.Typography

/**
 * Created by Aziza Helmy on 4/19/2024.
 */
@Composable
fun WeatherItem(state: WeatherItemUiState, index: Int) {
    Card(
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier
            .padding(8.dp)
            .semantics { contentDescription = "weatherItem" }
    ) {

        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Absolute.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            WeatherIcon(icon = state.weatherIcon)
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = when (index) {
                        0 -> stringResource(R.string.today)
                        1 -> stringResource(
                            R.string.tomorrow
                        )

                        else -> state.day
                    },
                    style = Typography.titleLarge,
                    modifier = Modifier
                        .semantics { contentDescription = "day" }
                )
                Text(
                    text = state.weatherDescription,
                    style = Typography.titleLarge,
                    modifier = Modifier
                        .semantics { contentDescription = "weatherDescriptionText" }
                )

                Text(
                    text = state.temperature,
                    style = Typography.bodyLarge,
                    modifier = Modifier
                        .semantics { contentDescription = "temperatureText" }
                )
            }
        }
    }
}

@Composable
fun WeatherIcon(icon: String) {
    val iconResource = when (icon) {
        "01d", "01n" -> R.drawable.ic_sun
        "02d" -> R.drawable.ic_few_cloudy
        "03d", "03n" -> R.drawable.ic_clouds
        "04d" -> R.drawable.ic_cloud
        "09d" -> R.drawable.ic_shower_rain
        "10d", "10n" -> R.drawable.ic_rainy
        "11d", "11n" -> R.drawable.ic_thunderstorm
        "13d", "13n" -> R.drawable.ic_snow
        "50d", "50n" -> R.drawable.ic_dark_cloud
        "02n" -> R.drawable.ic_scarred
        "04n" -> R.drawable.ic_dark_cloud
        else -> R.drawable.ic_clouds
    }

    Image(
        painter = rememberAsyncImagePainter(model = iconResource),
        contentDescription = "",
        modifier = Modifier
            .padding(16.dp)
            .size(90.dp)
    )
}