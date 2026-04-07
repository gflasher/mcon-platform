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
        // 로컬 Maven 저장소 (mcon-agnum 배포 artifact 참조용) [MCO-662]
        val localMavenRepo = System.getenv("MCON_LOCAL_MAVEN_REPO")
            ?: "${System.getProperty("user.home")}/mcon-maven-repo"
        maven {
            name = "MconLocalMaven"
            url = uri(localMavenRepo)
        }
    }
}

rootProject.name = "mcon-platform"

include(":bom")
include(":shared")
include(":androidApp")
include(":core:core-network")
include(":core:core-database")
include(":core:core-testing")
include(":core:core-ui")
include(":features:feature-readalert")
include(":features:feature-dotbomi")
include(":features:feature-settings")
