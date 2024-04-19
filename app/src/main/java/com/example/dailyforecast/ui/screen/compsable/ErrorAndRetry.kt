package com.example.dailyforecast.ui.screen.compsable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.dailyforecast.ui.screen.HomeInteractionListener

/**
 * Created by Aziza Helmy on 4/19/2024.
 */
@Composable
fun ErrorAndRetry(listener: HomeInteractionListener) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp, bottom = 8.dp)
    ) {
        Text(text = "Couldn't Fetch data")
        Button(onClick = { listener.onRetryClicked() }) {
            Text(text = "Retry")
        }
    }
}