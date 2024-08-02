pluginManagement {
//    plugins {
//        kotlin("jvm") version "2.0.0"
//    }
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}

rootProject.name = "Reply"
include(":app")
