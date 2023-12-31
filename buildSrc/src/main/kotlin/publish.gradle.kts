/**
 * Precompiled script plugin from:
 * https://github.com/cortinico/kotlin-android-template/blob/master/buildSrc/src/main/kotlin/publish.gradle.kts
 *
 * The following plugin tasks care of setting up:
 * - Publishing to Maven Central and Sonatype Snapshots
 * - GPG Signing with in memory PGP Keys
 * - Javadoc/SourceJar are attached via AGP
 *
 * To use it just apply:
 *
 * plugins {
 *     publish
 * }
 *
 * To your build.gradle.kts.
 *
 * If you copy over this file in your project, make sure to copy it inside: buildSrc/src/main/kotlin/publish.gradle.kts.
 * Make sure to copy over also buildSrc/build.gradle.kts otherwise this plugin will fail to compile due to missing dependencies.
 */
plugins {
    id("maven-publish")
    id("signing")
}

publishing {
    repositories {
        maven {
            name = "nexus"
            url = uri("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
            credentials {
                username = "NEXUS_USERNAME".byProperty
                password = "NEXUS_PASSWORD".byProperty
            }
        }
        maven {
            name = "snapshot"
            url = uri("https://s01.oss.sonatype.org/content/repositories/snapshots")
            credentials {
                username = "NEXUS_USERNAME".byProperty
                password = "NEXUS_PASSWORD".byProperty
            }
        }
    }

    publications {
        create<MavenPublication>("release") {
            groupId = PUBLISHING_GROUP
            artifactId = project.name
//            version = project.version.toString()
            afterEvaluate {
                if (plugins.hasPlugin("com.android.library")) {
                    from(components["release"])
                } else {
                    from(components["java"])
                }
            }

            pom {
                if (!"USE_SNAPSHOT".byProperty.isNullOrBlank()) {
                    version = "${project.version.toString()}-SNAPSHOT"
                }
                name.set(project.name)
                description.set("Port Firebase Java SDK to Python")
                url.set("https://github.com/SimpleJnius/sj-firebase-java/")

                licenses {
                    license {
                        name.set("The MIT License")
                        url.set("https://opensource.org/licenses/MIT")
                    }
                }
                developers {
                    developer {
                        id.set("kengoon")
                        name.set("Kenechukwu Akubue")
                        organization.set("Simple Jnius")
                        organizationUrl.set("https://github.com/organizations/SimpleJnius")
                    }
                }
                scm {
                    connection.set("scm:git:git://github.com/SimpleJnius/sj-firebase-java.git")
                    developerConnection.set("scm:git:ssh://github.com/SimpleJnius/sj-firebase-java.git")
                    url.set("https://github.com/SimpleJnius/sj-firebase-java/")
                }
                issueManagement {
                    system.set("GitHub Issues")
                    url.set("https://github.com/SimpleJnius/sj-firebase-java/issues")
                }
            }
        }
    }

    val signingKey = "SIGNING_KEY".byProperty
    val signingPwd = "SIGNING_PWD".byProperty
    if (signingKey.isNullOrBlank() || signingPwd.isNullOrBlank()) {
        logger.info("Signing Disable as the PGP key was not found")
    } else {
        logger.info("GPG Key found - Signing enabled")
        signing {
            useInMemoryPgpKeys(signingKey, signingPwd)
            sign(publishing.publications["release"])
        }
    }
}


val String.byProperty: String? get() = findProperty(this) as? String
