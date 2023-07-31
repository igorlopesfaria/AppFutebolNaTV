plugins {
    id("com.android.application") version ("8.0.0") apply false
    id("com.android.library") version ("8.0.0") apply false
    id("org.jetbrains.kotlin.android") version ("1.8.0") apply false
    id("org.jetbrains.kotlin.jvm") version ("1.8.0") apply false
    id("com.diffplug.spotless") version ("6.4.1") apply false
    id("com.google.dagger.hilt.android") version ("2.46.1") apply false
}

tasks.register("clean",Delete::class){
    delete(rootProject.buildDir)
}

buildscript {

    repositories {
        maven("https://plugins.gradle.org/m2/")
        mavenLocal()
        google()
        mavenCentral()
        maven("https://maven.fabric.io/public")
        maven("https://oss.jfrog.org/artifactory/oss-snapshot-local")
        maven ("https://oss.sonatype.org/content/repositories/snapshots/")
        maven ("https://jitpack.io" )
    }

    dependencies {
        classpath(Libs.Kotlin.getKotlinGradlePluginVersion())
        classpath(Libs.Gradle.getToolsGradleVersion())
        classpath(Libs.Spotless.getSpotlessVersion())
        classpath(Libs.DaggerHilt.getDaggerHiltPluginVersion())

        classpath(kotlin("gradle-plugin", Versions.KOTLIN_VERSION))
    }
}