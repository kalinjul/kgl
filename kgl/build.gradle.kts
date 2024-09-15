plugins {
    kotlin("multiplatform")
    id("maven-publish")
}

repositories {
    mavenCentral()
}

group = "com.danielgergely.kgl"
version = currentVersion

kotlin {
    jvm()

    js {
        browser {
            testTask {} // To run tests with browser.
        }
    }

    linuxX64()
    mingwX64()

    if (isMacOs()) {
        macosArm64()
        macosX64()
        iosArm64()
        iosX64()
        iosSimulatorArm64()
    }
    explicitApi()

    sourceSets {
        commonMain {
            dependencies {
                implementation(kotlin("stdlib-common"))
            }
        }
        commonTest {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        jvmMain {
            dependencies {
                implementation(kotlin("stdlib-jdk8"))
            }
        }
        jvmTest {
            dependencies {
                implementation(kotlin("test"))
                implementation(kotlin("test-junit"))
            }
        }
        jsMain {
            dependencies {
                implementation(kotlin("stdlib-js"))
            }
        }
        jsTest {
            dependencies {
                implementation(kotlin("test-js"))
            }
        }

        all {
            languageSettings.optIn("kotlinx.cinterop.ExperimentalForeignApi")
        }
    }
}

fun isMacOs() = org.gradle.internal.os.OperatingSystem.current().isMacOsX

publishing {
    addRepositoryIfPresent(project)
}
