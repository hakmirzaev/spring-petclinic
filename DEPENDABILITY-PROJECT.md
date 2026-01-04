# Spring PetClinic - Dependability Project

## Project Overview

This project demonstrates software dependability practices applied to the Spring PetClinic application, including:

- **Continuous Integration (CI)** with GitHub Actions
- **Code Coverage** with JaCoCo
- **Mutation Testing** with PITest
- **Containerization** with Docker
- **Formal Verification** with OpenJML/JML

## Repository

- **GitHub**: https://github.com/hakmirzaev/spring-petclinic
- **Branch**: `dependability-project`
- **DockerHub**: https://hub.docker.com/r/hakmirzaev/spring-petclinic

---

## 1. CI Pipeline (GitHub Actions)

### Location
`.github/workflows/ci.yml`

### What it does
1. **Build & Test**: Compiles the project and runs all unit/integration tests
2. **JaCoCo Coverage**: Generates code coverage report
3. **PITest Mutation Testing**: Runs mutation testing analysis
4. **Artifact Upload**: Uploads JaCoCo and PITest reports as downloadable artifacts
5. **Docker Build & Push**: Automatically builds and pushes Docker image to DockerHub

### Triggers
- Push to `dependability-project` branch
- Pull requests to `dependability-project` branch

### Artifacts Generated
- `jacoco-report` - Code coverage HTML report
- `pitest-report` - Mutation testing HTML report

---

## 2. Code Coverage (JaCoCo)

### Configuration
JaCoCo is configured in `pom.xml` with the `jacoco-maven-plugin`.

### Running Locally
```bash
./mvnw clean test jacoco:report
```

### Report Location
`target/site/jacoco/index.html`

### Evidence
- `evidence/` folder contains screenshots
- CI artifacts include the full report

---

## 3. Mutation Testing (PITest)

### Configuration
PITest is configured in `pom.xml` with the `pitest-maven` plugin.

### Running Locally
```bash
./mvnw org.pitest:pitest-maven:mutationCoverage
```

### Report Location
`target/pit-reports/index.html`

### Evidence
- CI artifacts include the full report
- Screenshots in `evidence/` folder

---

## 4. Docker & DockerHub

### Files
- `Dockerfile` - Multi-stage build for the application
- `docker-compose.yml` - Full stack with MySQL database

### Building Locally
```bash
docker build -t spring-petclinic .
```

### Running with Docker Compose
```bash
docker compose up
# Application available at http://localhost:8080
```

### DockerHub Image
```bash
docker pull hakmirzaev/spring-petclinic:latest
docker run -p 8080:8080 hakmirzaev/spring-petclinic:latest
```

### Evidence
- `evidence/docker/dockerhub-proof.txt` - Proof of DockerHub deployment

### CI Automated Push
The CI pipeline automatically pushes to DockerHub on every push to `dependability-project`.

**Required GitHub Secrets:**
- `DOCKERHUB_USERNAME` - Your DockerHub username
- `DOCKERHUB_TOKEN` - DockerHub access token (generate at https://hub.docker.com/settings/security)

---

## 5. Formal Verification (JML/OpenJML)

### Overview
Java Modeling Language (JML) specifications were added to key domain model classes to enable formal verification using OpenJML.

### JML Files Location
`jml-verification/`

### Classes with JML Specifications
- `BaseEntity.java` - ID management with invariants
- `NamedEntity.java` - Name property contracts
- `Person.java` - Person properties
- `Pet.java` - Pet with visits collection
- `Owner.java` - Owner with pets collection
- `Visit.java` - Veterinary visit records
- `Vet.java` - Veterinarian with specialties
- `PetValidator.java` - Validation logic
- `SimpleBaseEntity.java` - Clean ESC-verifiable version
- `SimplePerson.java` - Clean ESC-verifiable version
- `SimpleVisit.java` - Clean ESC-verifiable version

### JML Annotations Used
- `//@ requires` - Preconditions
- `//@ ensures` - Postconditions
- `//@ assignable` - Frame conditions
- `//@ pure` - No side effects
- `//@ invariant` - Class invariants
- `/*@ nullable @*/` - Nullability annotations

### Running OpenJML Verification

**Type Checking:**
```bash
openjml --check jml-verification/*.java
```

**Extended Static Checking (ESC):**
```bash
openjml --esc jml-verification/SimpleBaseEntity.java
openjml --esc jml-verification/SimplePerson.java
openjml --esc jml-verification/SimpleVisit.java
```

### Evidence
- `evidence/openjml/verification-report.txt` - Full verification report
- `evidence/openjml/esc-full-output.txt` - Detailed ESC output

---

## 6. Evidence Summary

### Directory Structure
```
evidence/
├── docker/
│   └── dockerhub-proof.txt    # DockerHub deployment proof
└── openjml/
    ├── verification-report.txt # OpenJML verification report
    └── esc-full-output.txt     # Full ESC verification output

jml-verification/              # JML-annotated source files
├── BaseEntity.java
├── NamedEntity.java
├── Person.java
├── Pet.java
├── Owner.java
├── Visit.java
├── Vet.java
├── PetValidator.java
├── SimpleBaseEntity.java
├── SimplePerson.java
└── SimpleVisit.java
```

---

## 7. JMH Microbenchmarks

### Overview
JMH (Java Microbenchmark Harness) benchmarks test the performance of the most demanding components in the application.

### Benchmark Classes
Located in `src/test/java/org/springframework/samples/petclinic/benchmark/`:

- `DomainModelBenchmark.java` - Tests entity creation and manipulation performance
- `OwnerRepositoryBenchmark.java` - Tests database query performance
- `VetRepositoryBenchmark.java` - Tests caching behavior performance
- `BenchmarkRunner.java` - Main runner class

### Running Benchmarks Locally
```bash
mvn test-compile
java -cp "target/test-classes:target/classes:$(mvn -q dependency:build-classpath -Dmdep.outputFile=/dev/stdout)" \
  org.springframework.samples.petclinic.benchmark.BenchmarkRunner
```

### CI Integration
Benchmarks run automatically in CI and results are uploaded as artifacts.

---

## 8. Security Analysis

### Tools Used
1. **Snyk** - Vulnerability scanning for dependencies
2. **OWASP Dependency Check** - CVE scanning
3. **SonarQube** - Code quality and security analysis

### CI Integration
All security scans run automatically in the CI pipeline:
- `security-snyk` job - Snyk vulnerability scan
- `security-dependency-check` job - OWASP dependency analysis
- `sonarqube` job - SonarQube code analysis

### Required Secrets for Security Scanning
Add these to GitHub Secrets:
- `SNYK_TOKEN` - Get from https://app.snyk.io/account
- `SONAR_TOKEN` - Get from your SonarQube instance
- `SONAR_HOST_URL` - Your SonarQube server URL

### Running Security Scans Locally

**OWASP Dependency Check:**
```bash
mvn org.owasp:dependency-check-maven:check
# Report: target/dependency-check-report.html
```

**Snyk (requires CLI):**
```bash
snyk test --all-projects
```

### Suppressing False Positives
Edit `dependency-check-suppressions.xml` to suppress known false positives.

---

## 9. Quick Commands Reference

```bash
# Run tests with coverage
./mvnw clean test jacoco:report

# Run mutation testing
./mvnw org.pitest:pitest-maven:mutationCoverage

# Build Docker image
docker build -t spring-petclinic .

# Run with Docker Compose
docker compose up

# Push to DockerHub (manual)
docker tag spring-petclinic hakmirzaev/spring-petclinic:latest
docker push hakmirzaev/spring-petclinic:latest

# OpenJML verification
openjml --check jml-verification/*.java
openjml --esc jml-verification/SimpleBaseEntity.java
```

---

## 10. Submission Checklist

- [x] CI Pipeline configured (GitHub Actions)
- [x] JaCoCo coverage reports generated
- [x] PITest mutation testing reports generated
- [x] Dockerfile created and tested
- [x] Docker Compose configuration
- [x] DockerHub image published
- [x] JML specifications added to domain classes
- [x] OpenJML verification executed
- [x] JMH microbenchmarks implemented
- [x] Security scanning (Snyk, OWASP, SonarQube)
- [x] Evidence documentation complete

---

**Generated**: January 4, 2026

