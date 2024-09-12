# Android Screenshot Testing Sample Repository

This repository is designed to explore and evaluate various libraries and techniques for screenshot testing in Android. 

The codebase is primarily based on the [android-compose-codelabs](https://github.com/android/codelab-android-compose)#Theming Codelab, 
with additional modifications to integrate and test different screenshot testing libraries.

## Introduction

Screenshot testing is a powerful tool for ensuring the visual correctness of UI components in Android applications. 

This repository aims to provide a practical example of how different screenshot testing libraries can be integrated into an Android project built with Jetpack Compose.

## Bottom Navigation Tabs
- **Inbox Screen**: A screen that displays a list of mails. Navigation to the detail screen is also available.
- **Contact List Screen**: A screen that displays a list of contacts. Navigation to the detail screen is also available. Using new Material 3 component [ListDetailPaneScaffold].
- **Animation Screen**: A screen that demonstrates several animations.
- **Setting Screen**: A screen that allows the user to change the theme and fonts of the app.

![Video Gif](...)

## Libraries and Tools

This repository includes configurations and examples for the following screenshot testing libraries:

- **[Roborazzi](https://github.com/takahirom/roborazzi)**: A lightweight library for generating and comparing screenshots.
  - The test code is located in the `test/.../roborazzi` package. 
  - You can find some examples of single tests in the package, and automated screenshot tests in the `allPreviews/ScreenshotTestForPreviews.kt` file by using Roborazzi and Showkase libraries.
  - Run `./gradlew recordRoborazziDebug ` to store reference screenshots, which will be located in the `build/outputs/roborazzi` directory.
  - Do some UI changes and run `./gradlew compareRoborazziDebug` to compare the screenshots with references ones, and see the differences in the `build/outputs/roborazzi` directory, test report in the `build/reports/roborazzi/index.html` file.
- **[Compose Preview Screenshot Testing](https://developer.android.com/studio/preview/compose-screenshot-testing)**: Utilizes the built-in Compose Preview to capture and compare screenshots.
  - The @Preview to be tested has been added under `/screenshotTest` source set.
  - No need for test code.
  - Run `./gradlew updateDebugScreenshotTest` to generate reference screenshots, the results are located in the `debug/screenshotTest/reference` directory.
  - Do some UI changes and run `./gradlew validateDebugScreenshotTest` to compare the screenshots with references ones, and see the report in the `/build/reports/screenshotTest/preview/debug/index.html` file.

## License

```
Copyright 2022 The Android Open Source Project

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
