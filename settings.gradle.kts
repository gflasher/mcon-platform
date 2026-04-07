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

rootProject.name = "mcon-platform"

include(":shared")
include(":androidApp")
include(":core:core-network")
include(":core:core-database")
include(":core:core-testing")
include(":core:core-ui")
include(":features:feature-readalert")
include(":features:feature-dotbomi")
include(":features:feature-settings")
