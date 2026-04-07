/**
 * Mcon.Agnum Screenshot 테스트 컨벤션 플러그인 (1-11)
 *
 * 적용: build.gradle.kts에 `id("com.mcon.agnum.screenshottest")` 추가
 *
 * 지원 타겟:
 * - Paparazzi: Android 모듈 (androidApp, core:core-ui)
 * - Roborazzi: KMP 공통 모듈 (shared 하위)
 *
 * 의존성 (MCO-621): MconAgnumTheme 구현 완료 후 사용 가능
 */
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class ScreenshotTestConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
            val isAndroidModule = pluginManager.hasPlugin("com.android.library") ||
                pluginManager.hasPlugin("com.android.application")

            if (isAndroidModule) {
                // Android 전용 모듈 → Paparazzi
                pluginManager.apply("app.cash.paparazzi")
                dependencies {
                    "testImplementation"(libs.findLibrary("kotlin-test").get())
                }
            } else {
                // KMP 모듈 → Roborazzi
                pluginManager.apply("io.github.takahirom.roborazzi")
                dependencies {
                    "testImplementation"(libs.findLibrary("roborazzi").get())
                    "testImplementation"(libs.findLibrary("roborazzi-compose").get())
                    "testImplementation"(libs.findLibrary("kotlin-test").get())
                }
            }
        }
    }
}
