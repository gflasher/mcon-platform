import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    `kotlin-dsl`
}

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
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.compose.gradlePlugin)
    compileOnly(libs.compose.compiler.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("kmpLibrary") {
            id = "com.mcon.agnum.kmp.library"
            implementationClass = "KmpLibraryConventionPlugin"
        }
        register("androidApplication") {
            id = "com.mcon.agnum.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("composeMultiplatform") {
            id = "com.mcon.agnum.compose.multiplatform"
            implementationClass = "ComposeMultiplatformConventionPlugin"
        }
        register("ktlint") {
            id = "com.mcon.agnum.ktlint"
            implementationClass = "KtlintConventionPlugin"
        }
        register("detekt") {
            id = "com.mcon.agnum.detekt"
            implementationClass = "DetektConventionPlugin"
        }
        register("screenshotTest") {
            id = "com.mcon.agnum.screenshottest"
            implementationClass = "ScreenshotTestConventionPlugin"
        }
        register("unitTest") {
            id = "com.mcon.agnum.unittest"
            implementationClass = "UnitTestConventionPlugin"
        }
        register("mavenPublish") {
            id = "com.mcon.agnum.maven.publish"
            implementationClass = "MavenPublishConventionPlugin"
        }
    }
}
