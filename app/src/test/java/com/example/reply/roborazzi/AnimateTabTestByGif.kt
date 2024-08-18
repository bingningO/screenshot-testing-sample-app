package com.example.reply.roborazzi

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.airbnb.lottie.LottieTask
import com.example.reply.roborazzi.TestUtil.checkScreenCapture
import com.example.reply.roborazzi.TestUtil.waitUntilIdle
import com.example.reply.roborazzi.allPreviews.ScreenshotTestCategory
import com.example.reply.ui.routes.animate.AnimateTab
import com.example.reply.ui.theme.AppTheme
import com.github.takahirom.roborazzi.RoborazziRule
import kotlinx.coroutines.test.StandardTestDispatcher
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.experimental.categories.Category
import org.junit.runner.RunWith
import org.robolectric.annotation.GraphicsMode
import java.util.concurrent.Executor
import java.util.concurrent.Executors

@RunWith(AndroidJUnit4::class)
@GraphicsMode(GraphicsMode.Mode.NATIVE)
class AnimateTabTestByGif{
    private val testDispatcher = StandardTestDispatcher()

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @get:Rule
    val roborazziRule = RoborazziRule(
        captureRoot = onView(ViewMatchers.isRoot()),
        options = RoborazziRule.Options(
            captureType = RoborazziRule.CaptureType.Gif(),
        )
    )

    @Before
    fun setup() {
        LottieTask.EXECUTOR = Executor(Runnable::run)
    }

    @After
    fun finished() {
        LottieTask.EXECUTOR = Executors.newCachedThreadPool()
    }

    @Test
    fun animateLottieTest() {
        composeTestRule.setContent {
            AppTheme {
                AnimateTab()
            }
        }
        waitUntilIdle(testRule = composeTestRule, testDispatcher = testDispatcher)
        composeTestRule.onNodeWithText("WORK").performClick()
        waitUntilIdle(testRule = composeTestRule, testDispatcher = testDispatcher)
        composeTestRule.onNodeWithText("HOME").performClick()
        waitUntilIdle(testRule = composeTestRule, testDispatcher = testDispatcher)
    }
}
