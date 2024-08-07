package com.example.reply.roborazzi

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.airbnb.lottie.LottieTask
import com.example.reply.roborazzi.allPreviews.ScreenshotTestCategory
import com.example.reply.ui.routes.animate.AnimateTab
import com.example.reply.ui.theme.AppTheme
import com.github.takahirom.roborazzi.RoborazziRule
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
class AnimateTabTest {
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
    @Category(ScreenshotTestCategory::class)
    fun animateLottieTest() {
        composeTestRule.setContent {
            AppTheme {
                AnimateTab()
            }
        }
        composeTestRule.onNodeWithText("WORK").performClick()
        composeTestRule.onNodeWithText("HOME").performClick()
    }
}
