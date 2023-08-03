plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}
android {
    compileSdk = AppConfig.compileSdkVersion
    namespace = "${AppConfig.applicationId}.core"

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
    kotlinOptions {
        jvmTarget = "17"
    }
}
dependencies {

    // Retrofit
    implementation(Libs.Retrofit.getRetrofitCoreVersion())
    implementation(Libs.Retrofit.getRetrofitMoshiConverterVersion())
}