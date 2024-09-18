import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
}


java {
    sourceCompatibility = JavaVersion.VERSION_17 // hardcode to default android studio embedded jdk version JavaVersion.toVersion(libs.versions.jvmTarget.get())
    targetCompatibility = JavaVersion.VERSION_17 // hardcode to default android studio embedded jdk version  JavaVersion.toVersion(libs.versions.jvmTarget.get())
}
tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions.jvmTarget = JavaVersion.VERSION_17.toString() // hardcode to default android studio embedded jdk version libs.versions.jvmTarget.get()
}