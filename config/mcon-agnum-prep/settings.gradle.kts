// mcon-agnum 저장소 settings.gradle.kts 템플릿 [MCO-661]
// Phase 1에서 신규 mcon-agnum GitHub 저장소에 그대로 복사

pluginManagement {
    includeBuild("build-logic")
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
        google()
        mavenCentral()
    }
}

rootProject.name = "mcon-agnum"

include(":bom")
include(":shared")
include(":core:core-network")
include(":core:core-database")
include(":core:core-testing")
include(":core:core-ui")
