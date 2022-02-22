plugins {
    id("com.android.application")
    id("dagger.hilt.android.plugin")
    kotlin("android")
    kotlin("kapt")
}

apply(from = "../gradles/basic-kapt-config.gradle")
apply(from = "../gradles/dagger-kapt-config.gradle")

android {
    compileSdk = 31
    buildToolsVersion = "31.0.0"

    defaultConfig {
        applicationId = "com.achmad.baseandroid"
        minSdk = 21
        targetSdk = 31
        versionCode = 1
        versionName = "1.0.0"

        val baseUrl: String by project
        buildConfigField("String", "BASE_URL", baseUrl)
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
        }
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        compose = true
        dataBinding = true
        viewBinding = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.0.1"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    packagingOptions {
        resources.excludes.addAll(
            listOf(
                "META-INF/AL2.0",
                "META-INF/LGPL2.1",
            )
        )
    }
    dynamicFeatures.addAll(mutableSetOf(":feature_post"))
}

dependencies {
    implementation(project(":common"))
    implementation(project(":feature_post_data"))

    // Android
    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.4.1")
    implementation("com.google.android.play:core-ktx:1.8.1")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.4.1")
    api("androidx.navigation:navigation-fragment-ktx:2.4.1")
    api("androidx.navigation:navigation-ui-ktx:2.4.1")
    api("androidx.navigation:navigation-dynamic-features-fragment:2.4.1")
    api("androidx.navigation:navigation-compose:2.5.0-alpha02")

    // Kotlin
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.6.10")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")

    // UI
    implementation("androidx.activity:activity-ktx:1.4.0")
    implementation("androidx.fragment:fragment-ktx:1.4.1")
    api("androidx.constraintlayout:constraintlayout:2.1.3")

    // Compose
    implementation("androidx.compose.ui:ui:1.1.0")
    implementation("androidx.compose.ui:ui-tooling:1.1.0")
    implementation("androidx.compose.ui:ui-tooling-preview:1.1.0")
    implementation("androidx.compose.material:material:1.1.0")
    implementation("androidx.activity:activity-compose:1.4.0")
    implementation("androidx.compose.runtime:runtime-livedata:1.1.0")
    implementation("io.coil-kt:coil-compose:1.4.0")

    // Paging
    implementation("androidx.paging:paging-compose:1.0.0-alpha14")

    // DI
    implementation("com.google.dagger:hilt-android:2.41")
    kapt("com.google.dagger:hilt-android-compiler:2.41")
    implementation("javax.inject:javax.inject:1")

    // Room
    implementation("androidx.room:room-runtime:2.4.1")
    implementation("androidx.room:room-ktx:2.4.1")
    kapt("androidx.room:room-compiler:2.4.1")

    // Network
    implementation("com.squareup.okhttp3:okhttp:4.9.1")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.1")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-moshi:2.9.0")
    implementation("com.github.skydoves:sandwich:1.2.1")
//    debugImplementation("com.github.ChuckerTeam.Chucker:library:3.5.2")
//    releaseImplementation("com.github.ChuckerTeam.Chucker:library-no-op:3.5.2")
}
