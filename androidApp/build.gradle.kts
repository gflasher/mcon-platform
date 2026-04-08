import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import java.io.ByteArrayOutputStream

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.compose.compiler)
}

// Git 커밋 수 기반 versionCode 자동 계산
fun gitCommitCount(): Int {
    return try {
        val stdout = ByteArrayOutputStream()
        exec {
            commandLine("git", "rev-list", "--count", "HEAD")
            standardOutput = stdout
        }
        stdout.toString().trim().toInt()
    } catch (e: Exception) {
        1
    }
}

fun gitShortHash(): String {
    return try {
        val stdout = ByteArrayOutputStream()
        exec {
            commandLine("git", "rev-parse", "--short", "HEAD")
            standardOutput = stdout
        }
        stdout.toString().trim()
    } catch (e: Exception) {
        "unknown"
    }
}

android {
    namespace = "com.mcon.agnum"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.mcon.agnum"
        minSdk = 23
        targetSdk = 34
        versionCode = gitCommitCount()
        versionName = "1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        // BuildConfig 활성화 (서버 URL 등 환경별 상수 접근)
        buildConfigField("String", "GIT_HASH", "\"${gitShortHash()}\"")
    }

    // ────────────────────────────────────────────────
    // 서명 설정 (환경별 분리)
    // ────────────────────────────────────────────────
    signingConfigs {
        // debug: 기본 debug.keystore 사용
        getByName("debug") {
            // Android 기본 debug.keystore 자동 사용
        }
        // staging: staging.keystore (GitHub Secret에서 복원)
        create("staging") {
            val keystoreFile = rootProject.file("androidApp/staging.keystore")
            if (keystoreFile.exists()) {
                storeFile = keystoreFile
                storePassword = System.getenv("STAGING_STORE_PASSWORD") ?: "staging"
                keyAlias = System.getenv("STAGING_KEY_ALIAS") ?: "staging"
                keyPassword = System.getenv("STAGING_KEY_PASSWORD") ?: "staging"
            }
        }
        // release: release.keystore (GitHub Production Secret에서 복원)
        create("release") {
            val keystoreFile = rootProject.file("androidApp/release.keystore")
            if (keystoreFile.exists()) {
                storeFile = keystoreFile
                storePassword = System.getenv("STORE_PASSWORD") ?: ""
                keyAlias = System.getenv("KEY_ALIAS") ?: ""
                keyPassword = System.getenv("KEY_PASSWORD") ?: ""
            }
        }
    }

    // ────────────────────────────────────────────────
    // 환경별 빌드 타입
    //   dev:      debug         → dev.mc-on.com    → debug.keystore
    //   staging:  debugStaging  → staging.mc-on.com → staging.keystore
    //   prod:     release       → prod.mc-on.com    → release.keystore
    // ────────────────────────────────────────────────
    buildTypes {
        // [dev] PR 검증 빌드
        debug {
            applicationIdSuffix = ".debug"
            versionNameSuffix = "-dev"
            isDebuggable = true
            signingConfig = signingConfigs.getByName("debug")
            buildConfigField("String", "BASE_URL", "\"https://dev.mc-on.com\"")
            buildConfigField("Boolean", "ENABLE_LOGGING", "true")
        }

        // [staging] main 브랜치 push 빌드
        create("debugStaging") {
            initWith(getByName("debug"))
            applicationIdSuffix = ".staging"
            versionNameSuffix = "-staging"
            isDebuggable = true
            signingConfig = signingConfigs.getByName("staging")
            buildConfigField("String", "BASE_URL", "\"https://staging.mc-on.com\"")
            buildConfigField("Boolean", "ENABLE_LOGGING", "true")
            matchingFallbacks += listOf("debug")
        }

        // [production] v*.*.* 태그 빌드
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            signingConfig = signingConfigs.getByName("release")
            buildConfigField("String", "BASE_URL", "\"https://prod.mc-on.com\"")
            buildConfigField("Boolean", "ENABLE_LOGGING", "false")
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
        jvmTarget = JvmTarget.JVM_17.target
    }

    buildFeatures {
        compose = true
        buildConfig = true
    }
}

dependencies {
    // Mcon.Agnum Maven 의존성 [MCO-670]
    implementation(libs.mcon.agnum.shared)
    implementation(libs.mcon.agnum.core.network)
    implementation(libs.mcon.agnum.core.database)
    implementation(libs.mcon.agnum.core.ui)

    // Feature 모듈 [MCO-675]
    implementation(project(":features:feature-readalert"))
    implementation(project(":features:feature-dotbomi"))
    implementation(project(":features:feature-settings"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime)
    implementation(libs.androidx.activity.compose)
    implementation(libs.koin.android)
    implementation(libs.koin.compose)
}
