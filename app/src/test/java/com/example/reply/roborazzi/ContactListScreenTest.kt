package com.example.reply.roborazzi

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.reply.data.LocalAccountsDataProvider
import com.example.reply.roborazzi.TestUtil.checkScreenCapture
import com.example.reply.roborazzi.TestUtil.waitUntilIdle
import com.example.reply.roborazzi.allPreviews.ScreenshotTestCategory
import com.example.reply.ui.routes.contacts.ContactsListScreen
import com.example.reply.ui.routes.contacts.ContactsViewModel
import kotlinx.coroutines.test.StandardTestDispatcher
import org.junit.Rule
import org.junit.Test
import org.junit.experimental.categories.Category
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.GraphicsMode

/**
 * a sample test for ListDetailPaneScaffold
 */
@RunWith(RobolectricTestRunner::class)
@GraphicsMode(GraphicsMode.Mode.NATIVE)
class ContactListScreenTest {

    private val testDispatcher = StandardTestDispatcher()

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    @Category(ScreenshotTestCategory::class)
    fun contactsListScreenTest_tablet() {
        RuntimeEnvironment.setQualifiers("w1280dp-h800dp-240dpi")

        composeTestRule.setContent {
            ContactsListScreen(viewModel = ContactsViewModel(dataProvider = LocalAccountsDataProvider))
        }
        composeTestRule.onNodeWithText("Google Express").performClick()
        waitUntilIdle(testRule = composeTestRule, testDispatcher = testDispatcher)
        checkScreenCapture(composeTestRule)
    }

    @Test
    @Category(ScreenshotTestCategory::class)
    fun contactsListScreenTest_phone() {
        RuntimeEnvironment.setQualifiers("w411dp-h891dp-port")

        composeTestRule.setContent {
            ContactsListScreen(viewModel = ContactsViewModel(dataProvider = LocalAccountsDataProvider))
        }
        composeTestRule.onNodeWithText("Google Express").performClick()
        waitUntilIdle(testRule = composeTestRule, testDispatcher = testDispatcher)
        checkScreenCapture(composeTestRule)
    }
}
