package com.example.reply.roborazzi

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollToIndex
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers
import com.example.reply.roborazzi.TestUtil.waitUntilIdle
import com.example.reply.ui.MainActivity
import com.github.takahirom.roborazzi.RobolectricDeviceQualifiers
import com.github.takahirom.roborazzi.captureRoboImage
import com.github.takahirom.roborazzi.captureScreenRoboImage
import kotlinx.coroutines.test.StandardTestDispatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.annotation.GraphicsMode

@RunWith(RobolectricTestRunner::class)
@GraphicsMode(GraphicsMode.Mode.NATIVE)
@Config(
    qualifiers = RobolectricDeviceQualifiers.Pixel7,
)
class ClickSecondTapTest {
    private val testDispatcher = StandardTestDispatcher()

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun clickSecondTapTest() {
        composeTestRule.onNodeWithTag(testTag = "Animation").performClick()
        waitUntilIdle(composeTestRule, testDispatcher)
        onView(ViewMatchers.isRoot()).captureRoboImage()

        composeTestRule.onNodeWithText("Settings").performClick()
        composeTestRule.onNodeWithTag("scrollable").performScrollToIndex(1)
        // capture the root composable
        composeTestRule.onRoot().captureRoboImage()
        // capture a specific composable
        composeTestRule.onNodeWithTag("AddBoxButton").captureRoboImage()
        // capture the whole screen including dialogs
        captureScreenRoboImage()
    }


}
