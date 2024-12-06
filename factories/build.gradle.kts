plugins {
    id("java-library")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:${findProperty("minecraftVersion")}-R0.1-SNAPSHOT")
    compileOnly(project(":api"))
    compileOnly(project(":implementations:1_20_6"))
    compileOnly(project(":implementations:1_21_3"))
    compileOnly(project(":implementations:1_21_4"))
}

tasks {
    java {
        withSourcesJar()
        withJavadocJar()
    }

    javadoc {
        options.encoding = Charsets.UTF_8.name()
    }

    compileJava {
        options.encoding = Charsets.UTF_8.name()
        options.release = 21

    }
}