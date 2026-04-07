import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.withType

/**
 * Mcon.Agnum 로컬 Maven 저장소 배포 컨벤션 플러그인 [MCO-661]
 *
 * 적용 효과:
 * - KMP 모듈의 모든 Publication에 groupId = "com.mc-on" 및 버전 자동 설정
 * - MCON_LOCAL_MAVEN_REPO 환경변수 기반 로컬 Maven 저장소 등록
 *
 * 환경 변수:
 *   MCON_LOCAL_MAVEN_REPO  — 저장소 경로 (기본값: ~/mcon-maven-repo)
 *   LIB_VERSION            — 배포 버전 (기본값: 1.0.0-SNAPSHOT)
 *
 * 사용법 (각 모듈 build.gradle.kts):
 *   plugins {
 *       id("com.mcon.agnum.maven.publish")
 *   }
 *
 * 배포 명령:
 *   ./gradlew publishAllPublicationsToLocalDirRepository
 */
class MavenPublishConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("maven-publish")

            val localMavenRepo: String =
                System.getenv("MCON_LOCAL_MAVEN_REPO")
                    ?: "${System.getProperty("user.home")}/mcon-maven-repo"

            val libVersion: String =
                System.getenv("LIB_VERSION")
                    ?: findProperty("libVersion")?.toString()
                    ?: "1.0.0-SNAPSHOT"

            // KMP 플러그인이 타겟별 Publication을 자동 생성한 뒤에 구성
            afterEvaluate {
                extensions.configure<PublishingExtension> {
                    publications.withType<MavenPublication>().configureEach {
                        groupId = "com.mc-on"
                        version = libVersion
                        // artifactId 는 KMP 플러그인이 모듈명 기반으로 자동 설정
                        // (예: core-network, core-network-android, core-network-iosArm64 등)
                    }

                    repositories {
                        maven {
                            name = "LocalDir"
                            url = uri(localMavenRepo)
                        }
                    }
                }
            }
        }
    }
}
