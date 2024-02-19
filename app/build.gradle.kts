plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    //id("com.google.devtools.ksp")
}

android {
    namespace = "com.epoxy.playground"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.epoxy.playground"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.jakewharton.timber:timber:5.0.1")
    implementation("com.github.kamrul3288:customview-android:1.1.2")
    implementation("com.tbuonomo:dotsindicator:5.0")
    implementation("io.coil-kt:coil-compose:2.5.0")
    implementation("de.hdodenhof:circleimageview:3.1.0")

    val epoxyVersion = "5.1.4"
    implementation("com.airbnb.android:epoxy:$epoxyVersion")
    kapt("com.airbnb.android:epoxy-processor:$epoxyVersion")
    implementation("com.airbnb.android:epoxy-viewbinder:$epoxyVersion")
    implementation("com.airbnb.android:epoxy-databinding:$epoxyVersion")

    val sdpVersion = "1.1.0"
    implementation("com.intuit.sdp:sdp-android:$sdpVersion")
    implementation("com.intuit.ssp:ssp-android:$sdpVersion")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}

kapt{
    correctErrorTypes = true
}

