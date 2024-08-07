import org.jetbrains.kotlin.builtins.StandardNames.FqNames.target

/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

plugins {
    id("com.android.application")
    alias(libs.plugins.kotlin)
    alias(libs.plugins.composeCompiler)
    id("dagger.hilt.android.plugin")
    id("kotlin-kapt")
    alias(libs.plugins.ksp)
//    id("app.cash.paparazzi")
    id("io.github.takahirom.roborazzi")
    alias(libs.plugins.screenshot)
}

android {
    namespace = "com.example.reply"
    compileSdk = 34
    defaultConfig {
        applicationId = "com.example.reply"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        vectorDrawables.useSupportLibrary = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("debug") {
            signingConfig = signingConfigs.getByName("debug")
        }

        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    testOptions {
        unitTests {
            isReturnDefaultValues = true
            isIncludeAndroidResources = true

            all {
                it.jvmArgs("-noverify")
                it.maxParallelForks = Runtime.getRuntime().availableProcessors()

                it.useJUnit {
                    if (project.hasProperty("screenshot")) {
                        project.logger.lifecycle("Screenshot tests are included, ${it.name}, ${it.classpath}")
                        includeCategories("com.example.reply.roborazzi.allPreviews.ScreenshotTestCategory")
                    }
                }
            }
        }
    }

    sourceSets {
        val sharedTestDir = "src/sharedTest/java"
        getByName("test") {
            java.srcDir(sharedTestDir)
        }
        getByName("androidTest") {
            java.srcDir(sharedTestDir)
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    experimentalProperties["android.experimental.enableScreenshotTest"] = true

    buildFeatures {
        compose = true
    }

    packagingOptions {
        resources {
            excludes += "/META-INF/AL2.0"
            excludes += "/META-INF/LGPL2.1"
        }
    }
}

dependencies {
    implementation(libs.composeGoogleFonts)
    val composeBom = platform(libs.composeBom)
    implementation(composeBom)
    testImplementation(composeBom)
    androidTestImplementation(composeBom)

    implementation(libs.runtime)
    implementation(libs.ui)
    implementation(libs.material3)
    implementation(libs.materialIconsExtended)
    implementation(libs.foundationLayout)
    implementation(libs.foundation)
    implementation(libs.animation)
    implementation(libs.uiToolingPreview)
    implementation(libs.runtimeLivedata)
    debugImplementation(libs.uiTooling)
    debugImplementation(libs.uiTestManifest)

    implementation(libs.kotlinxCoroutinesCore)
    implementation(libs.kotlinxCoroutinesAndroid)

    implementation(libs.datastorePreferences)

    implementation(libs.appcompat)
    implementation(libs.activityKtx)
    implementation(libs.coreKtx)
    implementation(libs.activityCompose)

    implementation(libs.lifecycleViewmodelKtx)
    implementation(libs.lifecycleViewmodelSavedstate)
    implementation(libs.lifecycleLivedataKtx)
    implementation(libs.lifecycleViewmodelCompose)

    implementation(libs.lottie.compose)

    testImplementation(libs.kermit.android.debug)

    // Dagger Hilt
    implementation(libs.daggerHilt)
    implementation(libs.daggerHiltWork)
    kapt(libs.daggerHiltCompiler)
    kapt(libs.hiltCompiler)
    implementation(libs.navigationCompose)
    implementation(libs.hiltNavigationCompose)

    // Testing
    implementation(libs.showkase)
    ksp(libs.showkaseKsp)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.rules)
    androidTestImplementation(libs.runner)
    testImplementation(libs.junit)
    testImplementation(libs.robolectric)
    testImplementation(libs.espresso.core)
    androidTestImplementation(libs.espresso.core)
    testImplementation(libs.uiTestJunit4)
    testImplementation(libs.testRoborazzi)
    testImplementation(libs.testRoborazziCompose)
    api(libs.testroborazziRule)
    screenshotTestImplementation(libs.uiTooling)
    screenshotTestImplementation(libs.uiToolingPreview)
    screenshotTestImplementation(composeBom)
    screenshotTestImplementation(libs.ui)
    screenshotTestImplementation(libs.material3)
    testImplementation(libs.hilt.android.testing)
    kaptTest(libs.daggerHiltCompiler)
    androidTestImplementation(libs.hilt.android.testing)
    kaptAndroidTest(libs.daggerHiltCompiler)
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions {
        // Treat all Kotlin warnings as errors (disabled by default)
        allWarningsAsErrors = project.findProperty("warningsAsErrors") as? Boolean ?: false

        freeCompilerArgs += listOf(
            "-opt-in=kotlin.RequiresOptIn",
            "-opt-in=kotlin.Experimental"
        )

        // Set JVM target to 1.8
        jvmTarget = "1.8"
    }
}
