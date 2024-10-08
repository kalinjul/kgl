plugins {
    id("com.android.library")
    id("kotlin-android")
    id("maven-publish")
}

android {
    compileSdk = 33

    namespace = "com.danielgergely.kgl_android"
    defaultConfig {
        minSdk = 21
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }

    sourceSets {
        getByName("main") {
            java.srcDir("src/main/kotlin")
        }
    }
}

dependencies {
    implementation(libs.org.jetbrains.kotlin.stdlib)

    implementation(project(":kgl"))
}

afterEvaluate {
    publishing {
        addRepositoryIfPresent(project)

        publications {
            create<MavenPublication>("maven") {
                from(project.components["release"])

                groupId = "com.danielgergely.kgl"
                artifactId = "kgl-android"
                version = currentVersion
            }
        }
    }
}
