plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {
    compileSdk = AppConfig.compileSdkVersion
    namespace = "${AppConfig.applicationId}.designsystem"

    defaultConfig {
        minSdk = AppConfig.minSdkVersion
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.0"
    }
    buildFeatures {
        compose = true
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(project(Modules.core))

    // Shimmer
    implementation("com.valentinilk.shimmer:compose-shimmer:1.0.5")
    implementation("io.coil-kt:coil-compose:2.4.0")

    implementation(Libs.Kotlin.coreKtxVersion())
    implementation(Libs.Activity.getActivityComposeVersion())
    implementation(platform(Libs.Compose.getComposeBOM()))
    implementation(Libs.Compose.getComposeMaterial3Version())
    implementation(Libs.Compose.getComposeToolingPreviewVersion())
    implementation(Libs.Compose.getComposeUIVersion())
    debugImplementation(Libs.Compose.getComposeToolingVersion())

}