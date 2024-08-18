package com.example.reply.roborazzi

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onRoot
import com.example.reply.ui.common.LoadingContent
import com.github.takahirom.roborazzi.captureRoboImage
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.GraphicsMode

@RunWith(RobolectricTestRunner::class)
@GraphicsMode(GraphicsMode.Mode.NATIVE)
class LoadingContentTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun loadingContentTest_start() {
        composeTestRule.setContent {
            LoadingContent(progress = 0.0f)
        }
        composeTestRule.onRoot().captureRoboImage()
    }

    @Test
    fun loadingContentTest_middle() {
        composeTestRule.setContent {
            LoadingContent(progress = 0.5f)
        }
        composeTestRule.onRoot().captureRoboImage()
    }

    @Test
    fun loadingContentTest_almostEnd() {
        composeTestRule.setContent {
            LoadingContent(progress = 0.9f)
        }
        composeTestRule.onRoot().captureRoboImage()
    }
}
