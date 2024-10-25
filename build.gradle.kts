plugins {
    id("java-library")
    id("maven-publish")

    id("io.github.goooler.shadow") version "8.1.7"
}

allprojects {
    group = "de.oliver"
    version = "0.0.10.1"
    description = "Simple, lightweight and fast library for minecraft internals"

    repositories {
        mavenLocal()
        mavenCentral()
        maven(url = "https://repo.papermc.io/repository/maven-public/")
        maven(url = "https://repo.fancyplugins.de/releases")
    }
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:${findProperty("minecraftVersion")}-R0.1-SNAPSHOT")

    implementation(project(":api"))
    implementation(project(":factories"))
    implementation(project(":implementations:1_21_3"))
    implementation(project(":implementations:1_20_6"))
    implementation("de.oliver.FancyAnalytics:logger:${findProperty("fancyLoggerVersion")}")
}

tasks {
    shadowJar {
        archiveClassifier.set("")
        configurations = listOf(project.configurations["runtimeClasspath"])
        dependencies {
            include(dependency("de.oliver:.*"))
        }
    }

    publishing {
        repositories {
            maven {
                name = "fancypluginsReleases"
                url = uri("https://repo.fancyplugins.de/releases")
                credentials(PasswordCredentials::class)
                authentication {
                    isAllowInsecureProtocol = true
                    create<BasicAuthentication>("basic")
                }
            }

            maven {
                name = "fancypluginsSnapshots"
                url = uri("https://repo.fancyplugins.de/snapshots")
                credentials(PasswordCredentials::class)
                authentication {
                    isAllowInsecureProtocol = true
                    create<BasicAuthentication>("basic")
                }
            }
        }
        publications {
            create<MavenPublication>("shadow") {
                groupId = project.group.toString()
                version = project.version.toString()
                artifact(shadowJar)
            }
        }
    }

    compileJava {
        options.encoding = Charsets.UTF_8.name()
        options.release = 21
    }

    javadoc {
        options.encoding = Charsets.UTF_8.name()
    }

    processResources {
        filteringCharset = Charsets.UTF_8.name()
    }
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(21))
}