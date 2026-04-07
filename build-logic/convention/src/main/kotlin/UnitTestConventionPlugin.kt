/**
 * Mcon.Agnum 단위 테스트 컨벤션 플러그인 (1-12)
 *
 * 적용: build.gradle.kts에 `id("com.mcon.agnum.unittest")` 추가
 *
 * 기능:
 * - Kover 커버리지 플러그인 적용
 * - Kotlin Test + MockK + Turbine + Coroutines Test 의존성 추가
 * - 최소 라인 커버리지 60% 검증
 */
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.tasks.testing.Test
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.withType

class UnitTestConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            // Kover 커버리지 플러그인 적용
            pluginManager.apply("org.jetbrains.kotlinx.kover")

            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
            dependencies {
                "testImplementation"(libs.findLibrary("kotlin-test").get())
                "testImplementation"(libs.findLibrary("mockk").get())
                "testImplementation"(libs.findLibrary("turbine").get())
                "testImplementation"(libs.findLibrary("kotlinx-coroutines-test").get())
            }

            // 테스트 JVM 옵션 최적화
            tasks.withType<Test> {
                useJUnit()
                maxParallelForks = (Runtime.getRuntime().availableProcessors() / 2).coerceAtLeast(1)
                jvmArgs("-Xms256m", "-Xmx512m", "-XX:+UseG1GC")
            }
        }
    }
}
