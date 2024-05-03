// build.gradle.kts
plugins {
    kotlin("multiplatform") version "1.9.23"
    kotlin("plugin.serialization") version "1.9.23"
}

repositories {
    mavenCentral()
}

kotlin {
    // mingwX64("windoes") // on Windows

    macosX64("macos") {
        binaries {
            executable()
        }
    }
    linuxX64("linux") {
        binaries {
            executable()
        }
    }

    sourceSets {
        commonMain {
            kotlin.srcDir("src/main")
            resources.srcDir("src/resources")
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")
                implementation("io.ktor:ktor-client-core:2.3.10")
                implementation("io.ktor:ktor-client-curl:2.3.10")
            }
        }
    }
}

tasks.withType<Wrapper> {
    gradleVersion = "8.7"
    distributionType = Wrapper.DistributionType.BIN
}
