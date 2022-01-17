plugins {
    id("com.android.dynamic-feature")
    id("dagger.hilt.android.plugin")
    kotlin("android")
    kotlin("kapt")
}

apply(from = "../gradles/basic-kapt-config.gradle")

android {
    compileSdk = Version.androidCompileSdk

    defaultConfig {
        minSdk = Version.androidMinSdk
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
    implementation(Lib.fragmentKtx)
    implementation(Lib.lifecycleLivedataKtx)

    // Compose
    implementation(Lib.composeUi)
    implementation(Lib.composeUiTooling)
    implementation(Lib.composeUiToolingPreview)
    implementation(Lib.composeMaterial)
    implementation(Lib.composeActivity)
    implementation(Lib.coil)

    // Paging
    implementation("androidx.paging:paging-compose:1.0.0-alpha13")

    // DI
    implementation(Lib.hiltAndroid)
    kapt(Lib.hiltAndroidCompiler)
}
