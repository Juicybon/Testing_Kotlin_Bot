import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    application
    kotlin("jvm") version "1.5.30"
    id("com.justai.jaicf.jaicp-build-plugin") version "0.1.1"
}

group = "com.justai.jaicf"
version = "1.0.0"

application {
    mainClass.set("template.scenario.mainScenario")
}

repositories {
    mavenLocal()
    mavenCentral()
    maven(uri("https://jitpack.io"))
}

val jaicf = "1.2.2"

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("com.just-ai.jaicf:core:$jaicf")
    implementation("com.just-ai.jaicf:jaicp:$jaicf")
    implementation("com.just-ai.jaicf:caila:$jaicf")
    implementation("com.just-ai.jaicf:telegram:$jaicf")
}

tasks.test {
    useJUnitPlatform()
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    shadowJar {
        archiveFileName.set("app.jar")
    }
}

tasks.create("stage") {
    dependsOn("shadowJar")
}

tasks.withType<com.justai.jaicf.plugins.jaicp.build.JaicpBuild> {
    mainClassName.set(application.mainClass)
}
