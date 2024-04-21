package com.example.dailyforecast.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.dailyforecast.ui.screen.HomeScreen
import com.example.dailyforecast.ui.theme.DailyForecastTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DailyForecastTheme {
                HomeScreen()
            }
        }
    }
}
