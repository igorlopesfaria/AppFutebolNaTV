pluginManagement {
    repositories {
        google()
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

rootProject.name = "AppFutebolNaTV"
include(":app")
include(":designsystem")
include(":core")
include(":analytics")
include(":feature:match")
include(":feature:home")
include(":feature:channel")
include(":feature:team")
include(":feature:championship")
