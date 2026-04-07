// 신규 앱 build.gradle.kts 템플릿 [MCO-673]
// mcon-agnum BOM 기반 의존성 선언 예시

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.compose.compiler)
}

android {
    // ← 신규 앱 namespace로 변경
    namespace = "com.example.mynewapp"
    compileSdk = 34

    defaultConfig {
        // ← 신규 앱 applicationId로 변경
        applicationId = "com.example.mynewapp"
        minSdk = 23
        targetSdk = 34
        versionCode = 1
        versionName = "1.0.0"
    }

    buildTypes {
        debug {
            isDebuggable = true
        }
        release {
            isMinifyEnabled = true
            isShrinkResources = true
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
        compose = true
    }
}

dependencies {
    // ──────────────────────────────────────────────────────
    // mcon-agnum: BOM으로 버전 일괄 관리
    // ──────────────────────────────────────────────────────
    implementation(platform(libs.mcon.agnum.bom))

    // 필요한 모듈만 선택 (버전 생략 — BOM이 관리)
    implementation(libs.mcon.agnum.shared)
    implementation(libs.mcon.agnum.core.ui)
    implementation(libs.mcon.agnum.core.network)
    implementation(libs.mcon.agnum.core.database)

    // ──────────────────────────────────────────────────────
    // AndroidX & Compose
    // ──────────────────────────────────────────────────────
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime)
    implementation(libs.androidx.activity.compose)

    implementation(platform(libs.compose.bom))
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.compose.material3)
}
