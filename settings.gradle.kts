pluginManagement {
    repositories {
        jcenter()
        mavenCentral()
        google()
        mavenCentral()

        maven { url = uri("https://jitpack.io") }
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
        maven {
            url = uri("https://maven.pkg.github.com/microsoft/onnxruntime")
        }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        jcenter()
        mavenCentral()
        google()
        maven { url = uri("https://jitpack.io") }
        maven { url = uri("https://s01.oss.sonatype.org/content/repositories/releases/") }
    }

}


rootProject.name = "My_Java_Application"
include(":app")
include(":chapter03")
include(":bitechtest")
include(":chapter04")
