plugins {
    java
    id("org.springframework.boot") version "3.1.0"
    id("io.spring.dependency-management") version "1.1.0"
}
val springCloudVersion by extra("2022.0.4")

group = "com.polywertz"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("com.miglayout:miglayout-swing:11.1")
    implementation("com.formdev:flatlaf:3.0")
    implementation("com.microsoft.sqlserver:mssql-jdbc:9.4.0.jre8")
    implementation("org.springframework.cloud:spring-cloud-function-context")
}
dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:$springCloudVersion")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
