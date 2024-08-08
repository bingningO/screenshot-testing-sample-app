package com.example.reply.roborazzi

import androidx.compose.ui.test.isRoot
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.onFirst
import com.github.takahirom.roborazzi.captureRoboImage
import kotlinx.coroutines.test.TestDispatcher

object TestUtil {

    fun waitUntilIdle(testRule: ComposeContentTestRule, testDispatcher: TestDispatcher) {
        testRule.waitForIdle()
        testDispatcher.scheduler.advanceUntilIdle()
    }

    fun checkScreenCapture(composeTestRule: ComposeContentTestRule) {
        composeTestRule
            .onAllNodes(isRoot())
            .onFirst()
            .captureRoboImage()
    }
}
