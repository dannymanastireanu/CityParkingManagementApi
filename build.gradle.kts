import org.gradle.api.tasks.bundling.Jar
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("java")
    application
    id("org.springframework.boot") version "3.0.0"
}

group = "com.goosfraba"
version = "1.0-SNAPSHOT"

tasks.named<BootJar>("bootJar") {
    archiveClassifier.set("boot")
}

tasks.named<Jar>("jar") {
    enabled = false
}

val cpmMainClass = "com.goosfraba.Application"

application {
    mainClass.set(cpmMainClass)
}

springBoot {
    mainClass.set(cpmMainClass)
}

tasks.named<BootJar>("bootJar") {
    mainClass.set(cpmMainClass)
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = cpmMainClass
    }
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.0")
    implementation("org.springframework.boot:spring-boot-starter-web:3.0.0")
    implementation("org.springframework.boot:spring-boot-autoconfigure:3.0.0")
    implementation("org.springframework.boot:spring-boot-gradle-plugin:3.0.0")
    implementation("org.springframework.boot:spring-boot-starter-tomcat")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}