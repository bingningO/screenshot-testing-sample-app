package com.example.reply.roborazzi

import androidx.compose.ui.test.junit4.createComposeRule
import com.airbnb.android.showkase.models.Showkase
import com.airbnb.android.showkase.models.ShowkaseBrowserComponent
import com.example.reply.module.getMetadata
import com.github.takahirom.roborazzi.DEFAULT_ROBORAZZI_OUTPUT_DIR_PATH
import com.github.takahirom.roborazzi.ExperimentalRoborazziApi
import com.github.takahirom.roborazzi.RobolectricDeviceQualifiers
import com.github.takahirom.roborazzi.captureRoboImage
import com.github.takahirom.roborazzi.captureScreenRoboImage
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.ParameterizedRobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config
import org.robolectric.annotation.GraphicsMode

/**
 * showkase gets all public/internal @Preview composable and roborazzi takes screenshots of them.
 */
@RunWith(ParameterizedRobolectricTestRunner::class)
@GraphicsMode(GraphicsMode.Mode.NATIVE)
@Config(
    // FIXME: The following configuration should be removed after robolectric supports sdk 35.
    sdk = [34],
    // default using a large-screen-size phone
    qualifiers = RobolectricDeviceQualifiers.Pixel7,
)
class ScreenshotTestForPreviews(
    private val showkaseBrowserComponent: ShowkaseBrowserComponent,
) {
    @get:Rule
    val composeTestRule = createComposeRule()

    // image loader
//    @OptIn(ExperimentalCoilApi::class)
//    @Before
//    fun before() {
//        val engine = FakeImageLoaderEngine.Builder()
//            .default(ColorDrawable(Color.DKGRAY))
//            .build()
//        val imageLoader = ImageLoader.Builder(ApplicationProvider.getApplicationContext())
//            .components { add(engine) }
//            .build()
//        Coil.setImageLoader(imageLoader)
//    }

    @Test
//    @Category(ScreenshotTestCategory::class)
    fun previewScreenshot() {
        val componentKey = showkaseBrowserComponent.componentKey
        val filePath = "$DEFAULT_ROBORAZZI_OUTPUT_DIR_PATH/$componentKey.png"
        println("componentKey: $componentKey")
        if (componentKey.contains("Dialog") || componentKey.contains("DropdownMenu")) {
            // Dialogs and DropdownMenu are not supported by captureRoboImage(), so we use captureScreenRoboImage() to capture the entire screen.
            // To jump into this condition, the Dialog @Preview composable must be named with "Dialog",
            // and the DropdownMenu @Preview composable must be named with "DropdownMenu".
            composeTestRule.setContent {
                showkaseBrowserComponent.component()
            }
            runCatching {
                @OptIn(ExperimentalRoborazziApi::class)
                (captureScreenRoboImage(filePath))
            }.onFailure {
                throw IllegalStateException(
                    "Failed to captureScreenRoboImage[${showkaseBrowserComponent.componentName}]",
                    it,
                )
            }
        } else {
            // Showkase not support device parameter of the preview composable.
            // so have to set group parameter and use RuntimeEnvironment.setQualifiers() to set the device.
            // issue created for Showkase: https://github.com/airbnb/Showkase/issues/388
            when {
                showkaseBrowserComponent.group.contains("TABLET") -> {
                    RuntimeEnvironment.setQualifiers("w1280dp-h800dp-240dpi")
                }

                showkaseBrowserComponent.group.contains("DESKTOP") -> {
                    RuntimeEnvironment.setQualifiers("w1920dp-h1080dp-160dpi")
                }

                showkaseBrowserComponent.group.contains("LONG_PHONE_DEVICE") -> {
                    RuntimeEnvironment.setQualifiers("w411dp-h1200dp-420dpi")
                }
            }

            runCatching {
                captureRoboImage(
                    filePath,
                ) {
                    showkaseBrowserComponent.component()
                }
            }.onFailure {
                throw IllegalStateException(
                    "Failed to captureRoboImage[${showkaseBrowserComponent.componentName}]",
                    it,
                )
            }
        }
    }

    companion object {

        @ParameterizedRobolectricTestRunner.Parameters
        @JvmStatic
        fun components(): Iterable<Array<Any?>> {
            return Showkase.getMetadata().componentList.map { showkaseBrowserComponent ->
                arrayOf(showkaseBrowserComponent)
            }
        }
    }
}
