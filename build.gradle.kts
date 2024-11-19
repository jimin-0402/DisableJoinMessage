plugins {
    kotlin("jvm") version "2.0.0"
    id("io.github.goooler.shadow") version "8.1.8"
}

group = "kr.jimin.disableJoinMessage"
version = "1.0.0"

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/") {
        name = "spigotmc-repo"
    }
}

dependencies {
    compileOnly("org.spigotmc:spigot-api:1.20.1-R0.1-SNAPSHOT")
}

tasks {

    processResources {
        val props = mapOf("version" to version)
        inputs.properties(props)
        filteringCharset = "UTF-8"
        filesMatching("plugin.yml") {
            expand(props)
        }
    }

    shadowJar {
        archiveFileName.set("${rootProject.name}-${rootProject.version}.jar")
//        destinationDirectory.set(file("C:/Users/aa990/OneDrive/바탕 화면/새 폴더 (10)/spawn/plugins"))
    }

    build.get().dependsOn(shadowJar)

}

kotlin {
    jvmToolchain(21)
}