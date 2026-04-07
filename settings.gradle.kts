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

// mcon-agnum Composite Build (로컬 개발 시 Maven 대신 소스 직접 참조) [MCO-670]
val mconAgnumDir = File(rootDir, "../mcon-agnum")
if (mconAgnumDir.exists()) {
    includeBuild(mconAgnumDir)
}

rootProject.name = "mcon-platform"

include(":androidApp")
include(":features:feature-readalert")
include(":features:feature-dotbomi")
include(":features:feature-settings")
