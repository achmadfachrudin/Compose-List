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
        kotlinCompilerExtensionVersion = "1.0.1"
    }
}

dependencies {
    implementation(project(":app"))
    implementation(project(":common"))
    implementation(project(":feature_post_data"))

    // UI
    implementation("androidx.fragment:fragment-ktx:1.4.1")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.4.1")

    // Compose
    implementation("androidx.compose.ui:ui:1.1.1")
    implementation("androidx.compose.ui:ui-tooling:1.1.1")
    implementation("androidx.compose.ui:ui-tooling-preview:1.1.1")
    implementation("androidx.compose.material:material:1.1.1")
    implementation("androidx.compose.material:material-icons-extended:1.1.1")
    implementation("androidx.compose.runtime:runtime-livedata:1.1.1")
    implementation("androidx.activity:activity-compose:1.4.0")
    implementation("io.coil-kt:coil-compose:1.4.0")

    // Paging
    implementation("androidx.paging:paging-compose:1.0.0-alpha14")

    // DI
    implementation("com.google.dagger:hilt-android:2.41")
    kapt("com.google.dagger:hilt-android-compiler:2.41")
}
