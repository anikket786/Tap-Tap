plugins {
    id("com.android.library")
    id("kotlin-kapt")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.twentyfourseven.gizmo"

    compileSdk = BuildConfigVersions.compileSdkVersion

    defaultConfig {
        minSdk = BuildConfigVersions.minSdkVersion
        targetSdk = BuildConfigVersions.targetSdkVersion

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
}

dependencies {
    implementation(project(":core:designsystem"))
    implementation(project(":core:navigation"))

    implementation(AndroidDependencies.coreKtx)
    implementation(AndroidDependencies.composeMaterial)
    implementation(AndroidDependencies.composeUi)
    implementation(AndroidDependencies.lifecycleRuntimeKtx)
    implementation(AndroidDependencies.activityCompose)
    implementation(AndroidDependencies.composeUiTooling)
    implementation(AndroidDependencies.composeUiToolingPreview)

    //hilt
    implementation(AndroidDependencies.hiltAndroid)
    kapt(AndroidDependencies.hiltCompiler)
    implementation(AndroidDependencies.hiltNavigationCompose)

    // Lottie
    implementation(AndroidDependencies.lottie)
}