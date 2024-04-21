package com.example.dailyforecast.ui.screen

import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.hasClickAction
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithContentDescription
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Created by Aziza Helmy on 4/20/2024.
 */

class HomeScreenTest {
    @get:Rule
    val rule = createComposeRule()
    private val result = rule.onNodeWithContentDescription("weatherList")

    @Before
    fun setUp() {
        rule.setContent { HomeScreen() }
    }

    private fun ComposeContentTestRule.performClickOnButton(text: String) {
        onNode(hasText(text) and hasClickAction()).performClick()
    }

    @Test
    fun testErrorAndRetry() {
        // Find and assert the existence of ErrorAndRetry
        //  rule.onNodeWithText("Retry").assertExists()
        val retryButton = rule.onNodeWithTag("retryButton")
        retryButton.assert(hasText("Retry"))
        // Perform any interactions with ErrorAndRetry
        // For example, to perform a click
        //  rule.onNodeWithText("Retry").performClick()
    }

    @Test
    fun should_getWeather_when_selectCityFromTheMenu() {
        rule.onNodeWithText("القاهرة")
        rule.onNodeWithContentDescription("selectCity").performClick()

    }

    @Test
    fun testWeatherItems() {
        // Find and assert the existence of WeatherItem
        // Here you can verify individual items as well
        rule.onAllNodesWithContentDescription("weatherList").assertCountEquals(1)

        // Perform any interactions with WeatherItem
        // For example, you can scroll and verify its content
        // rule.onAllNodesWithContentDescription("weatherList")[0].performScrollTo()
        //rule.onNodeWithText("weatherItem").assertExists()
    }
}