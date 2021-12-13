object Dependencies {

    object Modules {
        val domain by lazy { ":domain" }
        val domainAndroidOverlay by lazy { ":domain-android-overlay" }
        val presentation by lazy { ":presentation" }
        val infrastructure by lazy { ":infrastructure" }
    }

    object AndroidX {
        val coreKtx by lazy { "androidx.core:core-ktx:1.7.0" }
        val appcompat by lazy { "androidx.appcompat:appcompat:1.3.1" }
        val constraintLayout by lazy { "androidx.constraintlayout:constraintlayout:2.1.1" }
        val lifecycleRuntime by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:2.4.0" }
        val navigationFragment by lazy { "androidx.navigation:navigation-fragment-ktx:2.3.5" }
        val navigationUiKtx by lazy { "androidx.navigation:navigation-ui-ktx:2.3.5" }
        val viewModel by lazy { "androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0" }
        val fragmentKtx by lazy { "androidx.fragment:fragment-ktx:1.4.0" }
    }

    object AndroidLibs {
        val lottie by lazy { "com.airbnb.android:lottie:4.2.0" }

        val retrofit by lazy { "com.squareup.retrofit2:retrofit:2.9.0" }

        val retrofitGsonConverter by lazy { "com.squareup.retrofit2:converter-gson:2.9.0" }

        fun dependencies() = listOf(lottie, retrofit, retrofitGsonConverter)
    }

    object Google {
        val material by lazy { "com.google.android.material:material:1.4.0" }
        val hilt by lazy { "com.google.dagger:hilt-android:2.38.1" }
        val gmsServiceAuth by lazy { "com.google.android.gms:play-services-auth:20.0.0" }
    }


    object Test {
        val jUnit by lazy { "junit:junit:4.+" }
        val mockk by lazy { "io.mockk:mockk:1.12.0" }
        val coroutine by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.5.1" }
        val robolectric by lazy { "org.robolectric:robolectric:4.6" }
    }

    object AndroidTest {
        val jUnit by lazy { "androidx.test.ext:junit:1.1.3" }
        val jUnitKtx by lazy { "androidx.test.ext:junit-ktx:1.1.3" }
        val espresso by lazy { "androidx.test.espresso:espresso-core:3.4.0" }
    }

    object Debug {
        val leakCanary by lazy { "com.squareup.leakcanary:leakcanary-android:2.7" }
    }

    object KotlinLibs {
        val result by lazy { "com.github.kittinunf.result:result-jvm:5.2.0" }
        val coroutinesAndroid by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9" }
    }

    object Kapt {
        val hilt by lazy { "com.google.dagger:hilt-android-compiler:2.38.1" }
    }

    object ClassPath {
        val daggerHilt by lazy { "com.google.dagger:hilt-android-gradle-plugin:2.38.1" }
    }
}