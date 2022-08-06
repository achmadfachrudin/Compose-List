plugins {
    id("com.android.dynamic-feature")
    id("dagger.hilt.android.plugin")
    kotlin("android")
    kotlin("kapt")
}

apply(from = "../gradles/basic-kapt-config.gradle")

android {

    compileSdk = 31
    defaultConfig {
        minSdk = 21
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        compose = true
        dataBinding = true
        viewBinding = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.0-beta01"
    }
}

dependencies {
    implementation(project(":app"))
    implementation(project(":common"))
    implementation(project(":feature_post_data"))

    // UI
    implementation("androidx.fragment:fragment-ktx:1.5.1")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.5.1")

    // Compose
    implementation("androidx.compose.ui:ui:1.2.0")
    implementation("androidx.compose.ui:ui-tooling:1.2.0")
    implementation("androidx.compose.ui:ui-tooling-preview:1.2.0")
    implementation("androidx.compose.material:material:1.2.0")
    implementation("androidx.activity:activity-compose:1.5.1")
    implementation("io.coil-kt:coil-compose:2.1.0")

    // Paging
    implementation("androidx.paging:paging-compose:1.0.0-alpha15")

    // DI
    implementation("com.google.dagger:hilt-android:2.43.2")
    kapt("com.google.dagger:hilt-android-compiler:2.43.2")
}
