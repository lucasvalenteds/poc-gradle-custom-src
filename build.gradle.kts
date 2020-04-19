import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    java
}

repositories {
    jcenter()
}

dependencies {
    testImplementation("org.junit.jupiter", "junit-jupiter", properties["version.junit"].toString())
}

tasks.withType<Test> {
    useJUnitPlatform()
    testLogging {
        events = setOf(TestLogEvent.PASSED, TestLogEvent.FAILED)
    }
}

val integrationTest = sourceSets.create("integrationTest")

configurations {
    getByName(integrationTest.name + "Implementation") {
        extendsFrom(configurations.testImplementation.get())
    }

    getByName(integrationTest.name + "RuntimeOnly") {
        extendsFrom(configurations.testRuntime.get())
    }
}

tasks.register<Test>("itest") {
    useJUnitPlatform()
    testLogging {
        events = setOf(TestLogEvent.PASSED, TestLogEvent.FAILED)
    }
    testClassesDirs = sourceSets[integrationTest.name].output.classesDirs
    classpath = sourceSets[integrationTest.name].runtimeClasspath
}
