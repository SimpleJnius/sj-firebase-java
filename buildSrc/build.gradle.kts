plugins {
    `kotlin-dsl`
}
repositories {
    google()
    mavenCentral()
}

dependencies {
    // implementation(platform("org.jetbrains.kotlin:kotlin-bom:1.8.22"))

    // Specify only the modules you need and the BOM will provide the versions
    // implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    // implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation(libs.kgp)
    implementation(libs.agp)
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

kotlin {
    jvmToolchain(17)
}
