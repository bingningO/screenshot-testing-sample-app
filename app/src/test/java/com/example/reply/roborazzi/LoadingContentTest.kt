package com.example.reply.roborazzi

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onRoot
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.reply.ui.MainActivity
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
    fun loadingContentTest() {
        composeTestRule.setContent {
            LoadingContent()
        }
        composeTestRule.onRoot().captureRoboImage()
    }
}
