// 신규 프로젝트 settings.gradle.kts 템플릿 [MCO-673]
// mcon-agnum BOM 기반 신규 앱 시작점
// 이 파일을 신규 앱 루트에 복사하고 rootProject.name을 수정하세요.

pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        // 로컬 Maven 저장소 (mcon-agnum 로컬 빌드 참조)
        val localMavenRepo = System.getenv("MCON_LOCAL_MAVEN_REPO")
            ?: "${System.getProperty("user.home")}/mcon-maven-repo"
        maven(url = uri(localMavenRepo))

        google()
        mavenCentral()
    }
}

// ← 신규 앱 이름으로 변경
rootProject.name = "my-new-app"

include(":app")
