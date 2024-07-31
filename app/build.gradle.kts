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
    id("kotlin-android")
    id("org.jetbrains.kotlin.plugin.compose")
    id("dagger.hilt.android.plugin")
    id("kotlin-kapt")
    id("app.cash.paparazzi")
    id("io.github.takahirom.roborazzi")
}

android {
    namespace = "com.example.reply"
    compileSdk = 34
    defaultConfig {
        applicationId = "com.example.reply"
        minSdk = 21
        targetSdk = 33
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
            isIncludeAndroidResources = true
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
    testImplementation(libs.uiTestJunit4)
    androidTestImplementation(libs.uiTest)
    androidTestImplementation(libs.androidxUiTestJunit4)

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

    // Dagger Hilt
    implementation(libs.daggerHilt)
    implementation(libs.daggerHiltWork)
    kapt(libs.daggerHiltCompiler)
    kapt(libs.hiltCompiler)
    implementation(libs.navigationCompose)
    implementation(libs.hiltNavigationCompose)

    // Testing
    androidTestImplementation(libs.rules)
    testImplementation(libs.androidxComposeUiUiTestJunit4)
    testImplementation(libs.robolectric)
    testImplementation(libs.roborazzi)
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
//
//tasks.withType<Test>().configureEach {
//    systemProperty("robolectric.logging", "stdout")
//}
