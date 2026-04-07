import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
}

kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_17)
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "FeatureReadAlert"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            // Mcon.Agnum Maven 의존성 [MCO-670]
            implementation(libs.mcon.agnum.shared)
            implementation(libs.mcon.agnum.core.ui)
            implementation(compose.runtime)
            implementation(compose.material3)
            implementation(libs.koin.core)
        }
    }
}

android {
    namespace = "com.mcon.agnum.feature.readalert"
    compileSdk = 34

    defaultConfig {
        minSdk = 23
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}
