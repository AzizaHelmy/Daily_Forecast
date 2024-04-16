package com.example.dailyforecast.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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
    Column {
        DropDown(state)
        LazyColumn(
            modifier = Modifier.background(Color(0xFFF2F2F2)),
            contentPadding = PaddingValues(
                horizontal = 16.dp,
                vertical = 4.dp
            )
        ) {
            itemsIndexed(items = state.weatherItems) { _, user ->
                WeatherItem(user)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDown(state: HomeUiState) {

    var selectedText by remember {
        mutableStateOf(state.cities[0].cityNameAr)
    }
    var isExpanded by remember {
        mutableStateOf(false)
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp, bottom = 8.dp)
    ) {
        ExposedDropdownMenuBox(
            expanded = isExpanded,
            onExpandedChange = { isExpanded = !isExpanded }) {

            TextField(
                modifier = Modifier.menuAnchor(),
                value = selectedText,
                onValueChange = {},
                readOnly = true,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(
                        expanded = isExpanded
                    )
                })

            ExposedDropdownMenu(expanded = isExpanded, onDismissRequest = { isExpanded = false }) {
                state.cities.forEachIndexed { index, text ->
                    DropdownMenuItem(
                        text = { Text(text = text.cityNameAr) },
                        onClick = {
                            //todo: make a call
                            selectedText = state.cities[index].cityNameAr
                            isExpanded = false
                        },
                        contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                    )
                }
            }
        }
        Text(text = "Current selected $selectedText", modifier = Modifier.padding(vertical = 16.dp))
    }
}

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