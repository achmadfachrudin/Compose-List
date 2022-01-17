object Version {

    // Android
    const val androidBuildTools = "31.0.0"
    const val androidMinSdk = 21
    const val androidTargetSdk = 31
    const val androidCompileSdk = 31
    const val androidGradlePlugin = "7.0.4"

    // Kotlin
    const val kotlin = "1.5.21"
    const val coroutines = "1.5.0"
    const val kotlinSerialization = "1.2.0"

    // Network
    const val javaxAnnotation = "1.2.0"
    const val javaxInject = "1"
    const val gson = "2.8.1"
    const val moshi = "1.12.0"
    const val okHttp = "4.9.1"
    const val retrofit = "2.9.0"
    const val chucker = "3.5.2"
    const val sandwich = "1.2.1"

    // Jetpack
    const val androidAnnotations = "1.1.0"
    const val androidCore = "1.3.2"
    const val appCompat = "1.3.1"
    const val constraintLayout = "2.1.1"
    const val activity = "1.3.1"
    const val fragment = "1.3.4"
    const val lifecycle = "2.3.1"
    const val room = "2.3.0"
    const val compose = "1.0.1"
    const val composeActivity = "1.3.1"
    const val composeConstraintLayout = "1.0.0-beta02"
    const val hilt = "2.38.1"
    const val dagger = "2.34.1"

    // UI
    const val glide = "4.12.0"
    const val googleMaterial = "1.4.0"
    const val swipeRefresh = "1.1.0"
    const val recyclerView = "1.2.0"
    const val facebookShimmer = "0.5.0"
    const val epoxy = "4.6.2"
    const val lottie = "3.7.2"
    const val coil = "1.4.0"

    // Firebase
    const val firebaseBom = "28.3.0"

    // Google Services
    const val playServiceAuth = "18.1.0"
    const val playServiceAuthPhone = "17.4.0"
    const val playServiceLocation = "17.1.0"
    const val googleServices = "4.3.5"
    const val playCoreKtx = "1.8.1"

    // Testing
    const val archCoreTesting = "2.1.0"
    const val jUnit = "4.12"
    const val assertJ = "3.8.0"
    const val mockitoKotlin = "3.2.0"
    const val androidxTest = "1.3.0"
    const val androidxJUnit = "1.1.2"
    const val espresso = "3.3.0"
    const val mockk = "1.11.0"
    const val dexMaker = "2.28.1"
    const val barista = "4.0.0"

    // Utility
    const val ktlintGradle = "10.1.0"
    const val dependencyAnalysis = "0.71.0"
    const val leakCanary = "2.7"
    const val doctorPlugin = "0.7.0"
}

object Lib {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Version.kotlin}"
    const val kotlinReflect = "org.jetbrains.kotlin:kotlin-reflect:${Version.kotlin}"
    const val kotlinJUnit = "org.jetbrains.kotlin:kotlin-test-junit:${Version.kotlin}"
    const val kotlinSerializationJson =
        "org.jetbrains.kotlinx:kotlinx-serialization-json:${Version.kotlinSerialization}"
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.coroutines}"
    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.coroutines}"
    const val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Version.coroutines}"

    const val javaxAnnotation = "javax.annotation:jsr250-api:${Version.javaxAnnotation}"
    const val javaxInject = "javax.inject:javax.inject:${Version.javaxInject}"

    // Network
    const val gson = "com.google.code.gson:gson:${Version.gson}"
    const val okHttp = "com.squareup.okhttp3:okhttp:${Version.okHttp}"
    const val okHttpLogging = "com.squareup.okhttp3:logging-interceptor:${Version.okHttp}"
    const val okHttpMockWebServer = "com.squareup.okhttp3:mockwebserver:${Version.okHttp}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
    const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Version.retrofit}"
    const val retrofitMoshiConverter = "com.squareup.retrofit2:converter-moshi:${Version.retrofit}"
    const val chucker = "com.github.ChuckerTeam.Chucker:library:${Version.chucker}"
    const val chuckerNoop = "com.github.ChuckerTeam.Chucker:library-no-op:${Version.chucker}"
    const val sandwich = "com.github.skydoves:sandwich:${Version.sandwich}"

    // DI
    const val dagger = "com.google.dagger:dagger:${Version.dagger}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Version.dagger}"
    const val daggerAndroid = "com.google.dagger:dagger-android:${Version.dagger}"
    const val daggerAndroidSupport = "com.google.dagger:dagger-android-support:${Version.dagger}"
    const val daggerProcessor = "com.google.dagger:dagger-android-processor:${Version.dagger}"
    const val hiltAndroid = "com.google.dagger:hilt-android:${Version.hilt}"
    const val hiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:${Version.hilt}"

    // Androidx
    const val androidAnnotations = "androidx.annotation:annotation:${Version.androidAnnotations}"
    const val appCompat = "androidx.appcompat:appcompat:${Version.appCompat}"
    const val androidCoreKtx = "androidx.core:core-ktx:${Version.androidCore}"
    const val activityKtx = "androidx.activity:activity-ktx:${Version.activity}"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Version.fragment}"
    const val fragmentTesting = "androidx.fragment:fragment-testing:${Version.fragment}"
    const val lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.lifecycle}"
    const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Version.lifecycle}"
    const val lifecycleViewModelKtx =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.lifecycle}"
    const val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Version.lifecycle}"
    const val lifecycleLivedataKtx =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Version.lifecycle}"
    const val roomRuntime = "androidx.room:room-runtime:${Version.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Version.room}"
    const val roomKtx = "androidx.room:room-ktx:${Version.room}"
    const val roomTesting = "androidx.room:room-testing:${Version.room}"

    // UI
    const val lottie = "com.airbnb.android:lottie:${Version.lottie}"
    const val glide = "com.github.bumptech.glide:glide:${Version.glide}"
    const val glideAnnotation = "com.github.bumptech.glide:annotations:${Version.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Version.glide}"
    const val googleMaterial = "com.google.android.material:material:${Version.googleMaterial}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Version.constraintLayout}"
    const val swipeRefresh =
        "androidx.swiperefreshlayout:swiperefreshlayout:${Version.swipeRefresh}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Version.recyclerView}"
    const val facebookShimmer = "com.facebook.shimmer:shimmer:${Version.facebookShimmer}"
    const val epoxy = "com.airbnb.android:epoxy:${Version.epoxy}"
    const val epoxyProcessor = "com.airbnb.android:epoxy-processor:${Version.epoxy}"
    const val epoxyDataBinding = "com.airbnb.android:epoxy-databinding:${Version.epoxy}"

    // Compose
    const val composeUi = "androidx.compose.ui:ui:${Version.compose}"
    const val composeFoundation = "androidx.compose.foundation:foundation:${Version.compose}"
    const val composeMaterial = "androidx.compose.material:material:${Version.compose}"
    const val composeRuntime = "androidx.compose.runtime:runtime-livedata:${Version.compose}"
    const val composeUiTooling = "androidx.compose.ui:ui-tooling:${Version.compose}"
    const val composeUiToolingPreview = "androidx.compose.ui:ui-tooling-preview:${Version.compose}"
    const val composeActivity = "androidx.activity:activity-compose:${Version.composeActivity}"
    const val coil = "io.coil-kt:coil-compose:${Version.coil}"
    const val composeConstraintLayout =
        "androidx.constraintlayout:constraintlayout-compose:${Version.composeConstraintLayout}"
    const val composeRuntimeLiveData =
        "androidx.compose.runtime:runtime-livedata:${Version.compose}"

    // Firebase
    const val firebaseBom = "com.google.firebase:firebase-bom:${Version.firebaseBom}"
    const val firebaseAuth = "com.google.firebase:firebase-auth-ktx"
    const val firebaseRemoteConfig = "com.google.firebase:firebase-config"
    const val firebasePerf = "com.google.firebase:firebase-perf"
    const val firebaseMessaging = "com.google.firebase:firebase-messaging"
    const val firebaseCrashlyticsSdk = "com.google.firebase:firebase-crashlytics"
    const val firebaseAnalyticsKtx = "com.google.firebase:firebase-analytics-ktx"
    const val firebaseAppIndexing = "com.google.firebase:firebase-appindexing"

    // Google Services
    const val playServiceAuth =
        "com.google.android.gms:play-services-auth:${Version.playServiceAuth}"
    const val playServiceAuthPhone =
        "com.google.android.gms:play-services-auth-api-phone:${Version.playServiceAuthPhone}"
    const val playServiceLocation =
        "com.google.android.gms:play-services-location:${Version.playServiceLocation}"

    // Analytics
    const val playCoreKtx = "com.google.android.play:core-ktx:${Version.playCoreKtx}"
}

object LibTest {
    // Testing
    const val archCoreTesting = "androidx.arch.core:core-testing:${Version.archCoreTesting}"
    const val archCoreRunner = "androidx.arch.core:core-runner:${Version.archCoreTesting}"
    const val junit = "junit:junit:${Version.jUnit}"
    const val assertjCore = "org.assertj:assertj-core:${Version.assertJ}"
    const val mockitoKotlin = "org.mockito.kotlin:mockito-kotlin:${Version.mockitoKotlin}"
    const val testRunner = "androidx.test:runner:${Version.androidxTest}"
    const val testRules = "androidx.test:rules:${Version.androidxTest}"
    const val testCore = "androidx.test:core:${Version.androidxTest}"
    const val testJunitKtx = "androidx.test.ext:junit-ktx:${Version.androidxJUnit}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Version.espresso}"
    const val espressoIntents = "androidx.test.espresso:espresso-intents:${Version.espresso}"
    const val espressoContrib = "androidx.test.espresso:espresso-contrib:${Version.espresso}"
    const val espressoIdlingResource =
        "androidx.test.espresso:espresso-idling-resource:${Version.espresso}"
    const val mockk = "io.mockk:mockk:${Version.mockk}"
    const val mockkAndroid = "io.mockk:mockk-android:${Version.mockk}"
    const val dexMaker = "com.linkedin.dexmaker:dexmaker:${Version.dexMaker}"
    const val barista = "com.adevinta.android:barista:${Version.barista}"
    const val leakCanary = "com.squareup.leakcanary:leakcanary-android:${Version.leakCanary}"
}

object PluginClassPath {
    const val androidGradlePlugin = "com.android.tools.build:gradle:${Version.androidGradlePlugin}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.kotlin}"
    const val hiltGradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:${Version.hilt}"
    const val kotlinSerialization = "org.jetbrains.kotlin:kotlin-serialization:${Version.kotlin}"
    const val ktlintGradle = "org.jlleitschuh.gradle:ktlint-gradle:${Version.ktlintGradle}"
    const val doctorPlugin = "com.osacky.doctor:doctor-plugin:${Version.doctorPlugin}"
}
