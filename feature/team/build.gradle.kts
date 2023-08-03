plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-parcelize")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = AppConfig.compileSdkVersion
    namespace = "${AppConfig.applicationId}.team"

    defaultConfig {
        minSdk = AppConfig.minSdkVersion
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            multiDexEnabled = true
        }
        getByName("release") {
            isMinifyEnabled = false
            multiDexEnabled = true
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
    implementation(project(Modules.designsystem))

    //Compose
    implementation(platform(Libs.Compose.getComposeBOM()))
    implementation(Libs.Compose.getComposeMaterial3Version())
    implementation(Libs.Activity.getActivityComposeVersion())
    implementation(Libs.LifeCycleVersion.getLifeCycleComposeViewModelVersion())
    implementation(Libs.Compose.getComposeLiveDataVersion())
    debugImplementation(Libs.Compose.getComposeToolingVersion())
    androidTestImplementation(Libs.Compose.getComposeTestJUnitVersion())

    //Dagger Hilt
    implementation(Libs.DaggerHilt.getDaggerHiltAndroidVersion())
    kapt(Libs.DaggerHilt.getDaggerHiltCompilerVersion())

    //Hilt
    kapt(Libs.Hilt.getHiltCompilerVersion())

    // Okhttp3
    implementation(platform(Libs.OkHttp3.getBoomVersion()))
    implementation(Libs.OkHttp3.getCoreVersion())
    implementation(Libs.OkHttp3.getInterceptorVersion())

    // Retrofit
    implementation(Libs.Retrofit.getRetrofitCoreVersion())
    implementation(Libs.Retrofit.getRetrofitMoshiConverterVersion())

    // Coroutines
    api(Libs.Coroutines.getCoreVersion())
    api(Libs.Coroutines.getAndroidVersion())

    // Moshi
    implementation(Libs.Moshi.getMoshiVersion())

    // Timber
    implementation(Libs.Timber.getTimberVersion())

    // Test
    testImplementation(Libs.Test.getJunitVersion())
    testImplementation(Libs.Test.getMockkVersion())
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.COROUTINES_VERSION}")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test-jvm:${Versions.COROUTINES_VERSION}")

}
kapt {
    correctErrorTypes  = true
}
