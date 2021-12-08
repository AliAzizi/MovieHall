plugins {
    id("com.android.library")
    id("kotlin-android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = BuildConfig.compileSdkVersion

    defaultConfig {
        minSdk = BuildConfig.minSdkVersion
        targetSdk = BuildConfig.targetSdkVersion

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFile("consumer-rules.pro")
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

    buildFeatures{
        viewBinding = true
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
    implementation(Dependencies.Google.hilt)
    kapt(Dependencies.Kapt.hilt)

    implementation(Dependencies.AndroidLibs.retrofit)
    implementation(project(Dependencies.Modules.domain))
    implementation(Dependencies.Google.material)

    implementation(Dependencies.KotlinLibs.result)
    implementation(Dependencies.KotlinLibs.coroutinesAndroid)

    implementation(Dependencies.AndroidX.lifecycleRuntime)
    implementation(Dependencies.AndroidX.viewModel)

    testImplementation(Dependencies.Test.jUnit)
    testImplementation(Dependencies.Test.mockk)
    testImplementation(Dependencies.Test.coroutine)
    testImplementation(Dependencies.Test.robolectric)
    testImplementation(Dependencies.AndroidTest.jUnitKtx)

    androidTestImplementation(Dependencies.AndroidTest.jUnit)
    androidTestImplementation(Dependencies.AndroidTest.jUnitKtx)
    androidTestImplementation(Dependencies.AndroidTest.espresso)
}