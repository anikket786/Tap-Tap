import org.jetbrains.kotlin.gradle.targets.android.internal.AndroidDependency

plugins {
    id("com.android.application")
    id("kotlin-kapt")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    id("com.google.gms.google-services")
}

android {
    compileSdk = 33//BuildConfigVersions.compileSdkVersion

    defaultConfig {
        applicationId = "com.twentyfourseven.taptap"
        minSdk = BuildConfigVersions.minSdkVersion
        targetSdk = BuildConfigVersions.targetSdkVersion
        versionCode = BuildConfigVersions.versionCode
        versionName = BuildConfigVersions.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = AndroidDependencies.composeVersion
    }
    packagingOptions {
        resources.excludes.apply {
            add("/META-INF/{AL2.0,LGPL2.1}")
            add("META-INF/gradle/incremental.annotation.processors")
        }
    }
    namespace = "com.gromo.partner"
    buildToolsVersion = "31.0.0"
}

dependencies {
    implementation(project(":core:navigation"))
    implementation(project(":core:designsystem"))
    implementation(project(":feature:home"))
    implementation(project(":feature:gizmo"))

    // test
    testImplementation(AndroidDependencies.junit)
    androidTestImplementation(AndroidDependencies.extJunit)
    androidTestImplementation(AndroidDependencies.espressoCore)
    androidTestImplementation(AndroidDependencies.composeUiTestJunit)
    debugImplementation(AndroidDependencies.composeUiTestManifest)

    implementation(AndroidDependencies.coreKtx)
    implementation(AndroidDependencies.composeUi)
    implementation(AndroidDependencies.composeMaterial)
    implementation(AndroidDependencies.windowSizeClass)
    implementation(AndroidDependencies.composeUiToolingPreview)
    implementation(AndroidDependencies.activityCompose)
    debugImplementation(AndroidDependencies.composeUiTooling)
    implementation(AndroidDependencies.lifecycleRuntimeKtx)

    // hilt
    implementation(AndroidDependencies.hiltAndroid)
    kapt(AndroidDependencies.hiltCompiler)

    implementation(AndroidDependencies.navigationCompose)

    // google play
    implementation(AndroidDependencies.playCore)
}