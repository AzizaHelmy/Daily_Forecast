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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.example.dailyforecast.R
import com.example.dailyforecast.ui.screen.HomeInteractionListener
import com.example.dailyforecast.ui.theme.Typography

/**
 * Created by Aziza Helmy on 4/19/2024.
 */
@Composable
fun ErrorAndRetry(listener: HomeInteractionListener, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp, bottom = 8.dp)
            .semantics { contentDescription = "errorAndRetry" }
    ) {
        Text(
            text = stringResource(R.string.couldn_t_fetch_data),
            modifier = modifier.padding(top = 16.dp),
            style = Typography.titleLarge
        )
        Button(modifier = Modifier.padding(8.dp), onClick = { listener.onRetryClicked() }) {
            Text(text = stringResource(R.string.retry),style = Typography.titleLarge)
        }
    }
}