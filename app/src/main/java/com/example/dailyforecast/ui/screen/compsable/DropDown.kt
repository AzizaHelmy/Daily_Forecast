package com.example.dailyforecast.ui.screen.compsable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.example.dailyforecast.ui.screen.HomeInteractionListener
import com.example.dailyforecast.ui.screen.HomeUiState

/**
 * Created by Aziza Helmy on 4/19/2024.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDown(state: HomeUiState, listener: HomeInteractionListener) {

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
                    DropdownMenuItem( modifier = Modifier
                        .semantics { contentDescription = "selectCity" }
                        .fillMaxWidth(),
                        text = {
                            Text(text = text.cityNameAr, modifier = Modifier
                                .semantics { contentDescription = "selectCity" }
                                .fillMaxWidth()
                            )
                        },
                        onClick = {
                            listener.onCitySelected(
                                state.cities[index].lat,
                                state.cities[index].lon
                            )
                            selectedText = state.cities[index].cityNameAr
                            isExpanded = false
                        },
                        contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                    )
                }
            }
        }
    }
}
