pluginManagement {
    repositories {
        maven("https://maven.fabricmc.net/")
        maven("https://maven.kikugie.dev/releases")
        gradlePluginPortal()
    }
}

plugins {
    id("dev.kikugie.stonecutter") version "0.5.1"
}

stonecutter {
    kotlinController = true
    centralScript = "build.gradle.kts"

    create(rootProject) {
        versions(
            "1.20.1", "1.20.2", "1.20.3", "1.20.5",
            "1.21", "1.21.2", "1.21.4", "1.21.5", "1.21.6",
        )
    }
}

rootProject.name = "Redstone Sound Slider"
