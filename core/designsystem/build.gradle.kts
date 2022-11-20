plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.twentyfourseven.designsystem"
    compileSdk = 32
    defaultConfig {
        minSdk = 22
    }
    buildFeatures {
        compose = true
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.2.0"
    }
}

dependencies {
    implementation(AndroidDependencies.coreKtx)
    implementation(AndroidDependencies.composeUi)
    implementation(AndroidDependencies.composeMaterial)
    implementation(AndroidDependencies.composeUiToolingPreview)
    implementation(AndroidDependencies.activityCompose)
    debugImplementation(AndroidDependencies.composeUiTooling)
    implementation(AndroidDependencies.lifecycleRuntimeKtx)
    implementation(AndroidDependencies.systemUiController)
}