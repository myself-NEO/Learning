# Learning

## Overview
Small Java project for experimentation and learning. Contains source code, tests, and configuration suitable for use in IntelliJ IDEA.

## Prerequisites
- Java JDK 17 or newer
- IntelliJ IDEA 2024.1.7 (recommended)
- Maven or Gradle if you prefer command-line builds

## Importing into IntelliJ
1. Open IntelliJ IDEA.
2. Choose `File` → `Open` and select the project root folder.
3. If prompted, select the correct SDK (Java 17+) and import as a Maven/Gradle project if applicable.
4. Build and run via the green run icons or the IDE run configurations.

## Build & Run (CLI)
- Maven:
    - Build: `mvn clean package`
    - Run (if producing a jar): `java -jar target/your-artifact.jar`
- Gradle:
    - Windows: `.\gradlew build`
    - Run tests: `.\gradlew test`

## Running Tests
- From IntelliJ: Right-click the test directory or test class → `Run`
- CLI: Use `mvn test` or `.\gradlew test`

## Project Structure
- `src/main/java` — application source
- `src/test/java` — unit tests
- `pom.xml` or `build.gradle` — build configuration (if present)

## Contributing
- Fork the repository, create a feature branch, add tests, and open a pull request.
- Keep changes focused and include a short description in the PR.

## License
Add a `LICENSE` file to specify the project license. If none is present, consider adding an open-source license (for example, MIT).
