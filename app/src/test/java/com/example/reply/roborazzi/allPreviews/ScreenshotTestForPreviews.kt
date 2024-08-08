package com.example.reply.roborazzi.allPreviews

import androidx.compose.ui.test.junit4.createComposeRule
import com.airbnb.android.showkase.models.Showkase
import com.airbnb.android.showkase.models.ShowkaseBrowserComponent
import com.example.reply.module.getMetadata
import com.github.takahirom.roborazzi.DEFAULT_ROBORAZZI_OUTPUT_DIR_PATH
import com.github.takahirom.roborazzi.captureRoboImage
import org.junit.Rule
import org.junit.Test
import org.junit.experimental.categories.Category
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
    @Category(ScreenshotTestCategory::class)
    fun previewScreenshot_tablet() {
        val componentKey = showkaseBrowserComponent.componentKey
        val filePath = "$DEFAULT_ROBORAZZI_OUTPUT_DIR_PATH/tablet/$componentKey.png"
        println("componentKey tablet: $componentKey")
        RuntimeEnvironment.setQualifiers("w1280dp-h800dp-240dpi")

        captureRoboImage(filePath)
    }

    @Test
    @Category(ScreenshotTestCategory::class)
    fun previewScreenshot_phone_landscape() {
        val componentKey = showkaseBrowserComponent.componentKey
        val filePath = "$DEFAULT_ROBORAZZI_OUTPUT_DIR_PATH/phone/landscape/$componentKey.png"
        println("componentKey phone landscape: $componentKey")
        RuntimeEnvironment.setQualifiers("w411dp-h891dp-land");

        captureRoboImage(filePath)
    }

    @Test
    @Category(ScreenshotTestCategory::class)
    fun previewScreenshot_phone_portrait() {
        val componentKey = showkaseBrowserComponent.componentKey
        val filePath = "$DEFAULT_ROBORAZZI_OUTPUT_DIR_PATH/phone/portrait/$componentKey.png"
        println("componentKey phone portrait: $componentKey")
        RuntimeEnvironment.setQualifiers("w411dp-h891dp-port");

        captureRoboImage(filePath)
    }

    private fun captureRoboImage(filePath: String) {
        runCatching {
            captureRoboImage(filePath) {
                showkaseBrowserComponent.component()
            }
        }.onFailure {
            throw IllegalStateException(
                "Failed to captureRoboImage[${showkaseBrowserComponent.componentName}]",
                it,
            )
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
