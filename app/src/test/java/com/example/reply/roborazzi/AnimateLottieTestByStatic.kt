package com.example.reply.roborazzi

import androidx.compose.ui.test.isRoot
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.airbnb.lottie.LottieTask
import com.example.reply.roborazzi.TestUtil.checkScreenCapture
import com.example.reply.roborazzi.TestUtil.waitUntilIdle
import com.example.reply.roborazzi.allPreviews.ScreenshotTestCategory
import com.example.reply.ui.routes.animate.AnimateLottie
import com.github.takahirom.roborazzi.captureRoboImage
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestDispatcher
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.experimental.categories.Category
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.GraphicsMode
import java.util.concurrent.Executor
import java.util.concurrent.Executors

@RunWith(RobolectricTestRunner::class)
@GraphicsMode(GraphicsMode.Mode.NATIVE)
class AnimateLottieTestByStatic {

    private val testDispatcher = StandardTestDispatcher()

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setup() {
        LottieTask.EXECUTOR = Executor(Runnable::run)
    }

    @After
    fun finished() {
        LottieTask.EXECUTOR = Executors.newCachedThreadPool()
    }

    @Test
    @Category(ScreenshotTestCategory::class)
    fun animateLottieTest() {
        composeTestRule.setContent {
            AnimateLottie()
        }
        waitUntilIdle(testRule = composeTestRule, testDispatcher = testDispatcher)
        checkScreenCapture(composeTestRule)
    }
}
