plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-parcelize")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = AppConfig.compileSdkVersion
    namespace = AppConfig.applicationId

    defaultConfig {
        applicationId = AppConfig.applicationId
        minSdk = AppConfig.minSdkVersion
        targetSdk = AppConfig.targetSdkVersion
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        vectorDrawables.useSupportLibrary = true
        multiDexEnabled = true
        manifestPlaceholders["scheme_app"] = AppConfig.scheme
    }

    buildTypes {
        getByName("debug") {
            isTestCoverageEnabled = true
            isDebuggable = true
            isMinifyEnabled = false
            multiDexEnabled = true
        }
        getByName("release") {
            isDebuggable = false
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

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.0"
    }
    buildFeatures {
        compose = true
    }

    lint {
        checkReleaseBuilds = false
        checkDependencies = true
        checkAllWarnings = true
        warningsAsErrors = true
        abortOnError = false
    }

    testOptions {
        unitTests.isIncludeAndroidResources = true
        unitTests.isReturnDefaultValues = true
    }
}

dependencies {

    implementation(project(Modules.core))
    implementation(project(Modules.analytics))
    implementation(project(Modules.designsystem))
    implementation(project(Modules.channel))
    implementation(project(Modules.home))
    implementation(project(Modules.match))
    implementation(project(Modules.team))

    implementation(Libs.DaggerHilt.getDaggerHiltAndroidVersion())
    kapt(Libs.DaggerHilt.getDaggerHiltCompilerVersion())
    kapt(Libs.Hilt.getHiltCompilerVersion())

    debugImplementation(Libs.Compose.getComposeToolingVersion())

    // Moshi
    implementation(Libs.Moshi.getMoshiVersion())
    // Okhttp3
    implementation(platform(Libs.OkHttp3.getBoomVersion()))
    implementation(Libs.OkHttp3.getCoreVersion())
    implementation(Libs.OkHttp3.getInterceptorVersion())

    // Retrofit
    implementation(Libs.Retrofit.getRetrofitCoreVersion())
    implementation(Libs.Retrofit.getRetrofitMoshiConverterVersion())

    testImplementation(Libs.Test.getJunitVersion())
}