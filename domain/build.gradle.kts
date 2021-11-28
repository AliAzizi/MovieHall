plugins {
    id("java-library")
    id("kotlin")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_7
    targetCompatibility = JavaVersion.VERSION_1_7
}

dependencies {
    implementation(Dependencies.KotlinLibs.coroutinesAndroid)
    implementation(Dependencies.KotlinLibs.result)
}