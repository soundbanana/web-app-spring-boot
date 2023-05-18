plugins {
    id("java")
    id("org.springframework.boot") version "2.7.8"
}

apply(plugin = "io.spring.dependency-management")

group = "com.chemaev"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("org.springframework.boot:spring-boot-starter-mail")

    implementation("org.thymeleaf.extras:thymeleaf-extras-springsecurity5:3.0.4.RELEASE")
    implementation("org.thymeleaf:thymeleaf-spring5:3.0.15.RELEASE")

    implementation("org.hibernate:hibernate-validator:8.0.0.Final")

    //db
    implementation("org.postgresql:postgresql:42.5.3")

    //lombok
    compileOnly("org.projectlombok:lombok:1.18.24")
    annotationProcessor("org.projectlombok:lombok:1.18.24")

    //webkjars
    implementation("org.webjars:jquery:3.6.0")
    implementation("org.webjars:bootstrap:4.6.0")
    implementation("org.webjars:webjars-locator-core:0.46")

    //test
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")

    implementation("javax.mail:javax.mail-api:1.6.2")

    implementation("com.fasterxml.jackson.core:jackson-annotations:2.13.0")
    implementation("javax.servlet:javax.servlet-api:4.0.1")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "com.chemaev.Application"
    }
}
