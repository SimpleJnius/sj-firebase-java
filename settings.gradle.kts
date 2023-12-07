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

rootProject.name = ("sj-firebase-java")

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

//include("app")
include(":sjfirebase")
