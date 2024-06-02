plugins {
    id("java-library")
    id("maven-publish")

    id("xyz.jpenilla.run-paper") version "2.2.4"
    id("io.github.goooler.shadow") version "8.1.7"
    id("net.minecrell.plugin-yml.paper") version "0.6.0"
}

runPaper.folia.registerTask()

repositories {
    mavenLocal()
    mavenCentral()
    maven(url = "https://repo.papermc.io/repository/maven-public/")
    maven(url = "https://repo.fancyplugins.de/releases")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:${findProperty("minecraftVersion")}-R0.1-SNAPSHOT")

    implementation(project(":api"))
    implementation(project(":factories"))
    implementation(project(":implementations:1_20_6"))
}

paper {
    name = "FancySitulaTestPlugin"
    main = "de.oliver.fancysitula.FancySitulaPlugin"
    bootstrapper = "de.oliver.fancysitula.loaders.FancySitulaPluginBootstrapper"
    loader = "de.oliver.fancysitula.loaders.FancySitulaPluginLoader"
    foliaSupported = true
    version = "1.0.0"
    description = "Test plugin for FancySitula"
    apiVersion = "1.19"
}

tasks {
    runServer {
        minecraftVersion(findProperty("minecraftVersion").toString())
//        minecraftVersion("1.20.4")
    }

    shadowJar {
        archiveClassifier.set("")
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