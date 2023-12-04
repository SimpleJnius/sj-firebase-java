pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = ("sjfirebasejava")

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

//include("app")
include(":sjfirebase")
