package com.example.reply.roborazzi

import androidx.compose.ui.Modifier
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.reply.data.dummySettingUIState
import com.example.reply.ui.routes.setting.SettingScreenSuccess
import com.example.reply.ui.theme.AppTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.GraphicsMode

@RunWith(AndroidJUnit4::class)
@GraphicsMode(GraphicsMode.Mode.NATIVE)
class SettingScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun settingScreenTest() {
        composeTestRule.setContent {
            AppTheme {
                SettingScreenSuccess(
                    modifier = Modifier,
                    state = dummySettingUIState,
                    toggleTheme = {},
                    changeTypographyMode = {})
            }
        }
//        composeTestRule.onRoot().captureRoboImage()
    }
}
