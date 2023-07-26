// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
    }
    dependencies {
        val navVersion = "2.6.0"
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$navVersion")
    }
}

plugins {
    id("com.android.application") version "8.2.0-alpha03" apply false
    id("org.jetbrains.kotlin.android") version "1.8.0" apply false
    id("com.google.dagger.hilt.android") version "2.45" apply false
}