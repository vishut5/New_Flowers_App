plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.vishu.newflowers"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.vishu.newflowers"
        minSdk = 23
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildFeatures {
        viewBinding = true
    }
        buildTypes {
            release {
                isMinifyEnabled = false
                proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
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
    }

    dependencies {
        implementation("androidx.constraintlayout:constraintlayout:2.1.0")
        implementation("com.squareup.retrofit2:retrofit:2.9.0")
        implementation("com.squareup.retrofit2:converter-gson:2.9.0")
        implementation("com.github.bumptech.glide:glide:4.12.0")
        annotationProcessor("com.github.bumptech.glide:compiler:4.12.0")

        // RecyclerView for displaying lists
        implementation("androidx.recyclerview:recyclerview:1.2.1")

        // Coroutine support
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.0")

        // Lifecycle components
        implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.3.1")
        implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1")
        implementation("androidx.recyclerview:recyclerview:1.2.1")
        implementation("androidx.vectordrawable:vectordrawable:1.1.0")
        implementation(libs.androidx.core.ktx)
        implementation(libs.androidx.appcompat)
        implementation(libs.material)
        implementation(libs.androidx.activity)
        implementation(libs.androidx.constraintlayout)
        testImplementation(libs.junit)
        androidTestImplementation(libs.androidx.junit)
        androidTestImplementation(libs.androidx.espresso.core)
    }
