plugins {
    id("com.android.application")
    id("dagger.hilt.android.plugin")
    kotlin("android")
    kotlin("kapt")
}

apply(from = "../gradles/basic-kapt-config.gradle")
apply(from = "../gradles/dagger-kapt-config.gradle")

android {
    compileSdk = Version.androidCompileSdk
    buildToolsVersion = Version.androidBuildTools

    defaultConfig {
        applicationId = "com.achmad.baseandroid"
        minSdk = Version.androidMinSdk
        targetSdk = Version.androidTargetSdk
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
    implementation(Lib.androidCoreKtx)
    implementation(Lib.appCompat)
    implementation(Lib.playCoreKtx)
    implementation(Lib.lifecycleLivedataKtx)
    api("androidx.navigation:navigation-fragment-ktx:2.3.5")
    api("androidx.navigation:navigation-ui-ktx:2.3.5")
    api("androidx.navigation:navigation-dynamic-features-fragment:2.3.5")
    api("androidx.navigation:navigation-compose:2.4.0-rc01")

    // Kotlin
    implementation(Lib.kotlin)
    implementation(Lib.coroutinesCore)

    // UI
    implementation(Lib.activityKtx)
    implementation(Lib.fragmentKtx)
    api(Lib.constraintLayout)

    // Compose
    implementation(Lib.composeUi)
    implementation(Lib.composeUiTooling)
    implementation(Lib.composeUiToolingPreview)
    implementation(Lib.composeMaterial)
    implementation(Lib.composeActivity)
    implementation(Lib.composeRuntimeLiveData)
    implementation(Lib.coil)

    // Paging
    implementation("androidx.paging:paging-compose:1.0.0-alpha13")

    // DI
    implementation(Lib.hiltAndroid)
    kapt(Lib.hiltAndroidCompiler)
    implementation(Lib.javaxInject)

    // Room
    implementation(Lib.roomRuntime)
    implementation(Lib.roomKtx)
    kapt(Lib.roomCompiler)

    // Network
    implementation(Lib.okHttp)
    implementation(Lib.okHttpLogging)
    implementation(Lib.retrofit)
    implementation(Lib.retrofitMoshiConverter)
    implementation(Lib.sandwich)
//    debugImplementation(Lib.chucker)
//    releaseImplementation(Lib.chuckerNoop)
}
