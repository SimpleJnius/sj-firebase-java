version = LibraryAndroidCoordinates.LIBRARY_VERSION

@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("com.android.library")
    id("maven-publish")
    publish
    id("com.google.gms.google-services")
}

android {
    namespace = "com.simplejnius.sjfirebase"
    compileSdk = 34

    defaultConfig {
        minSdk = libs.versions.min.sdk.version.get().toInt()
        namespace = "com.simplejnius.sjfirebase"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    publishing {
        singleVariant("release") {
            withSourcesJar()
            withJavadocJar()
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
//    lint {
//        warningsAsErrors = true
//        abortOnError = true
//        disable.add("GradleDependency")
//        baseline = file("lint-baseline.xml")
//    }
}

dependencies {

    // implementation(libs.androidx.appcompat)
    // implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
    // implementation(platform("org.jetbrains.kotlin:kotlin-bom:1.8.22"))

    // Specify only the modules you need and the BOM will provide the versions
    // implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    // implementation("org.jetbrains.kotlin:kotlin-reflect")
    // Import the BoM for the Firebase platform
    implementation(platform(libs.firebase.bom))

    // Add the dependency for the Firebase Authentication library
    // When using the BoM, you don't specify versions in Firebase library dependencies
    //noinspection UseTomlInstead
    implementation("com.google.firebase:firebase-auth")
    //noinspection UseTomlInstead
    implementation("com.google.firebase:firebase-firestore")
    //noinspection UseTomlInstead
    implementation("com.google.firebase:firebase-database")
    //noinspection UseTomlInstead
    implementation("com.google.firebase:firebase-storage")
    //noinspection UseTomlInstead
    implementation("com.google.firebase:firebase-functions")
}

