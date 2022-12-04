plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.twentyfourseven.util"

    compileSdk = BuildConfigVersions.compileSdkVersion

    defaultConfig {
        minSdk = BuildConfigVersions.minSdkVersion
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(platform(AndroidDependencies.firebaseBom))
    implementation(AndroidDependencies.firebaseCore)
    releaseImplementation(AndroidDependencies.firebaseAnalytics)
    releaseImplementation(AndroidDependencies.firebaseAnalyticsKtx)
    implementation(AndroidDependencies.firebaseInAppMessaging)
}