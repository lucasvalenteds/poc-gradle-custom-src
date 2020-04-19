# POC: Gradle Custom Source

It demonstrates how to add a custom source folder to Gradle build script written using Kotlin DSL.

This setup may be useful to separate unit tests from other types of tests like integration, acceptance or stress.

## How to run

| Description | Command |
| :--- | :--- |
| Run tests in `src/test` | `./gradlew test` |
| Run tests in `src/integrationTest` | `./gradlew itest` |
