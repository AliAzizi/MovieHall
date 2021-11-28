plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {
    compileSdk = BuildConfig.compileSdkVersion

    defaultConfig {
        applicationId = "com.kotlinbyte.msc"
        minSdk = BuildConfig.minSdkVersion
        targetSdk = BuildConfig.targetSdkVersion
        versionCode = BuildConfig.versionCode
        versionName = BuildConfig.versionName

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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(project(Dependencies.Modules.presentation))


    implementation(Dependencies.AndroidX.coreKtx)
    implementation(Dependencies.AndroidX.appcompat)
    implementation(Dependencies.Google.material)

    testImplementation(Dependencies.Test.jUnit)
    
    androidTestImplementation(Dependencies.AndroidTest.jUnit)
    androidTestImplementation(Dependencies.AndroidTest.espresso)
}