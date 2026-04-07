import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    `kotlin-dsl`
}

group = "com.mcon.agnum.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

kotlin {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_17
    }
}

dependencies {
    compileOnly(libs.plugins.android.application.get().let { "${it.pluginId}:${it.pluginId}.gradle.plugin:${it.version}" })
    compileOnly(libs.plugins.android.library.get().let { "${it.pluginId}:${it.pluginId}.gradle.plugin:${it.version}" })
    compileOnly(libs.plugins.kotlin.multiplatform.get().let { "org.jetbrains.kotlin:kotlin-gradle-plugin:${it.version}" })
}

// TODO: [MCO-625] CTO가 컨벤션 플러그인 구현 예정
// KmpLibraryConventionPlugin, AndroidApplicationConventionPlugin 등
gradlePlugin {
    plugins {
        // 플러그인은 CTO가 MCO-625에서 구현
    }
}
