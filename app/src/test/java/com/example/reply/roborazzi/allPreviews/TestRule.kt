package com.example.reply.roborazzi.allPreviews

import co.touchlab.kermit.CommonWriter
import co.touchlab.kermit.Logger
import com.airbnb.lottie.LottieTask
import com.github.takahirom.roborazzi.ExperimentalRoborazziApi
import com.github.takahirom.roborazzi.RoborazziOptions
import com.github.takahirom.roborazzi.RoborazziRule
import dagger.hilt.android.testing.HiltAndroidRule
import org.junit.rules.RuleChain
import org.junit.rules.TestRule
import org.junit.rules.TestWatcher
import org.junit.runner.Description
import org.junit.runners.model.Statement
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class LottieTestRule : TestWatcher() {
    private val defaultExecutor = Executors.newCachedThreadPool()

    override fun starting(description: Description) {
        LottieTask.EXECUTOR = Executor(Runnable::run)
    }

    override fun finished(description: Description) {
        LottieTask.EXECUTOR = defaultExecutor
    }
}

/**
 * todo hasn't been used
 */
@OptIn(ExperimentalRoborazziApi::class)
class RobotTestRule(
    private val testInstance: Any,
//    val composeTestRule: AndroidComposeTestRule<ActivityScenarioRule<*>, *>,
) : TestRule {
    override fun apply(base: Statement, description: Description): Statement {
        return RuleChain
            .outerRule(HiltAndroidAutoInjectRule(testInstance))
//            .around(CoroutinesTestRule())
//            .around(TimeZoneTestRule())
            .around(LottieTestRule())
            .around(object : TestWatcher() {
                override fun starting(description: Description) {
                    // To see logs in the console
                    Logger.setLogWriters(CommonWriter())
                }
            })
            .around(
                RoborazziRule(
                    RoborazziRule.Options(
                        roborazziOptions = RoborazziOptions(
                            compareOptions = RoborazziOptions.CompareOptions(
                                // Detect small changes
                                changeThreshold = 0.000001F,
                            ),
                            recordOptions = RoborazziOptions.RecordOptions(
                                // For saving money
                                pixelBitConfig = RoborazziOptions.PixelBitConfig.Rgb565,
                            ),
                        ),
                    ),
                ),
            )
//            .around(composeTestRule)
            .apply(base, description)
    }
}

class HiltAndroidAutoInjectRule(
    private val testInstance: Any,
) : TestRule {
    override fun apply(base: Statement?, description: Description?): Statement {
        val hiltAndroidRule = HiltAndroidRule(testInstance)
        return RuleChain
            .outerRule(hiltAndroidRule)
            .around(HiltInjectRule(hiltAndroidRule))
            .apply(base, description)
    }
}

class HiltInjectRule(private val rule: HiltAndroidRule) : TestWatcher() {
    override fun starting(description: Description?) {
        super.starting(description)
        rule.inject()
    }
}
