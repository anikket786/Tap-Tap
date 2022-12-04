object AndroidDependencies {
    // Test
    const val junit = "junit:junit:4.13.2"
    const val extJunit = "androidx.test.ext:junit:1.1.3"
    const val espressoCore = "androidx.test.espresso:espresso-core:3.4.0"


    const val coreKtx = "androidx.core:core-ktx:1.9.0"

    // compose
    const val composeVersion = "1.2.0"
    const val composeUi = "androidx.compose.ui:ui:$composeVersion"
    const val composeUiToolingPreview = "androidx.compose.ui:ui-tooling-preview:$composeVersion"
    const val composeUiTestJunit = "androidx.compose.ui:ui-test-junit4:$composeVersion"
    const val composeUiTooling = "androidx.compose.ui:ui-tooling:$composeVersion"
    const val composeUiTestManifest = "androidx.compose.ui:ui-test-manifest:$composeVersion"
    const val activityCompose = "androidx.activity:activity-compose:1.6.0"
    const val lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:2.5.1"

    // Material
    const val windowSizeClass = "androidx.compose.material3:material3-window-size-class:1.0.0-rc01"
    const val composeMaterial = "androidx.compose.material:material:1.3.0-rc01"

    const val annotation = "androidx.annotation:annotation:1.5.0"

    // Accompanist
    const val systemUiController = "com.google.accompanist:accompanist-systemuicontroller:0.27.0"

    // Hilt
    const val androidGradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:2.42"
    const val hiltAndroid = "com.google.dagger:hilt-android:2.42"
    const val hiltCompiler = "com.google.dagger:hilt-compiler:2.42"
    const val hiltNavigationCompose = "androidx.hilt:hilt-navigation-compose:1.0.0"

    // Navigation
    const val navigationCompose = "androidx.navigation:navigation-compose:2.5.2"

    // Firebase
    const val firebaseCore = "com.google.firebase:firebase-core:21.1.1"
    const val firebaseMessaging = "com.google.firebase:firebase-messaging:23.0.8"
    const val firebaseInstallation = "com.google.firebase:firebase-installations:17.0.3"
    const val firebaseBom = "com.google.firebase:firebase-bom:29.0.3"
    const val firebaseInAppMessaging = "com.google.firebase:firebase-inappmessaging-display-ktx"
    const val firebaseAnalytics = "com.google.firebase:firebase-analytics"
    const val firebaseAnalyticsKtx = "com.google.firebase:firebase-analytics-ktx"
    const val firebaseCrashlytics = "com.google.firebase:firebase-crashlytics"
    const val firebaseCrashlyticsKtx = "com.google.firebase:firebase-crashlytics-ktx"
    const val firebasePerf = "com.google.firebase:firebase-perf:20.1.1"
    const val firebaseCrashlyticsPlugin = "com.google.firebase:firebase-crashlytics-gradle:2.9.2"
    const val firebasePerfPlugin = "com.google.firebase:perf-plugin:1.4.1"

    // Google play services
    const val playCore = "com.google.android.play:core:1.10.3"
    const val googleServices = "com.google.gms:google-services:4.3.14"

    // Lottie
    const val lottie = "com.airbnb.android:lottie-compose:5.2.0"
}