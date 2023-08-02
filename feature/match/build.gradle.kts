plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-parcelize")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = AppConfig.compileSdkVersion
    namespace = "${AppConfig.applicationId}.match"

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
    implementation(project(Modules.designsystem))
    implementation(project(Modules.team))
    implementation(project(Modules.channel))

    //Coil 
    implementation(Libs.Coil.getCoilVersion())

    //Shimmer
    implementation(Libs.Shimmer.getShimmerVersion())

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
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")


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
