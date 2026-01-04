# Software Dependability Project – Spring PetClinic

**Author:** Bekhruzjon Hakmirzaev  
**Matricola:** NF22500050  
**Email:** b.hakmirzaev@studenti.unisa.it  
**University:** University of Salerno  
**Program:** Master in Internet of Things (Department of Computer Engineering)  
**Course:** Software Dependability  
**Professor:** Dario Di Nucci  
**Date:** January 2026

---

## 📋 Project Overview

**Repository:** https://github.com/hakmirzaev/spring-petclinic  
**Branch:** `dependability-project`  
**DockerHub:** `hakmirzaev/spring-petclinic:latest`

This project presents a comprehensive dependability analysis of the Spring PetClinic application using modern software engineering practices including CI/CD, automated testing, mutation testing, formal verification, performance benchmarking, and security analysis.

---

## ✅ Evaluation Criteria Checklist

| # | Requirement | Status | Evidence |
|---|-------------|--------|----------|
| 1 | Application buildable in CI/CD and locally | ✅ PASS | GitHub Actions `build-test` job |
| 2 | Core methods have JML specs verified by OpenJML | ✅ PASS | `jml-verification/` directory, `evidence/openjml/` |
| 3 | Docker image available in DockerHub | ✅ PASS | `hakmirzaev/spring-petclinic:latest` |
| 4 | Significant number of test cases | ✅ PASS | 50+ tests, 98% line coverage |
| 5 | Code coverage analyzed using JaCoCo | ✅ PASS | `jacoco-report` artifact (281 KB) |
| 6 | Mutation testing with PITest | ✅ PASS | `pitest-report` artifact, 70% mutation score |
| 7 | JMH microbenchmarks | ✅ PASS | `benchmarks` job, 4 benchmark classes |
| 8 | Security mechanisms in CI/CD | ✅ PASS | Snyk, OWASP, SonarQube jobs |
| 9 | Security analyzed (GitGuardian, Snyk, SonarQube) | ✅ PASS | All security jobs pass |
| 10 | Web application shows no vulnerabilities | ✅ PASS | `dependency-check-report` artifact (94.9 KB) |

---

## 📊 Key Metrics

### Test Coverage (JaCoCo)
- **Line Coverage:** 98%
- **Branch Coverage:** 84%
- **Methods Tested:** 108

### Mutation Testing (PITest)
- **Generated Mutations:** 143
- **Killed Mutations:** 100
- **Mutation Score:** 70%
- **Test Strength:** 76%

### CI/CD Pipeline
- **Total Duration:** 31m 12s
- **Jobs:** 6 parallel jobs
- **Status:** All jobs passed ✅

---

## 🔧 Implementation Details

### 1. CI/CD Pipeline (GitHub Actions)

Location: `.github/workflows/ci.yml`

```yaml
jobs:
  build-test:              # Tests + JaCoCo + PITest
  benchmarks:              # JMH Performance Tests  
  security-snyk:           # Snyk Vulnerability Scan
  security-dependency-check: # OWASP Dependency Check
  sonarqube:               # SonarQube Analysis
  docker-push:             # Docker Image to DockerHub
```

### 2. JML Formal Verification

Location: `jml-verification/`

Verified classes:
- `SimpleBaseEntity.java` - ESC Verified ✅
- `SimplePerson.java` - ESC Verified ✅
- `SimpleVisit.java` - ESC Verified ✅
- `BaseEntity.java`, `Person.java`, `Pet.java`, `Owner.java`, `Visit.java`, `Vet.java` - Type Check Passed ✅

Example JML specification:
```java
//@ ensures \result == id;
//@ pure
public Integer getId() {
    return id;
}
```

### 3. JMH Benchmarks

Location: `src/test/java/org/springframework/samples/petclinic/benchmark/`

- `DomainModelBenchmark.java` - Entity operations
- `OwnerRepositoryBenchmark.java` - Database queries
- `VetRepositoryBenchmark.java` - Caching behavior
- `BenchmarkRunner.java` - Main runner

### 4. Docker Configuration

```bash
# Build and run locally
docker compose up -d

# Pull from DockerHub
docker pull hakmirzaev/spring-petclinic:latest
```

### 5. Security Scanning

| Tool | Purpose | Result |
|------|---------|--------|
| Snyk | Dependency vulnerabilities | No high/critical issues |
| OWASP Dependency Check | CVE scanning | No CVEs above threshold |
| SonarQube | Static analysis | No security hotspots |

---

## 📁 Project Structure

```
spring-petclinic/
├── .github/workflows/ci.yml    # CI/CD pipeline
├── jml-verification/           # JML-annotated source files
│   ├── SimpleBaseEntity.java
│   ├── SimplePerson.java
│   └── ... (11 files)
├── evidence/
│   └── openjml/
│       ├── verification-report.txt
│       └── esc-full-output.txt
├── report/
│   ├── REPORT.md               # This summary
│   └── main.tex                # LaTeX report (ACM format)
├── src/test/java/.../benchmark/
│   ├── DomainModelBenchmark.java
│   ├── OwnerRepositoryBenchmark.java
│   ├── VetRepositoryBenchmark.java
│   └── BenchmarkRunner.java
├── Dockerfile
├── docker-compose.yml
├── pom.xml
└── DEPENDABILITY-PROJECT.md
```

---

## 🚀 How to Run

### Local Build
```bash
mvn clean install -DskipTests
mvn test
```

### Run Tests with Coverage
```bash
mvn test jacoco:report
open target/site/jacoco/index.html
```

### Run Mutation Testing
```bash
mvn org.pitest:pitest-maven:mutationCoverage
open target/pit-reports/index.html
```

### Run JMH Benchmarks
```bash
mvn test-compile
java -cp "target/test-classes:target/classes:$(mvn dependency:build-classpath -q -Dmdep.outputFile=/dev/stdout)" \
  org.springframework.samples.petclinic.benchmark.BenchmarkRunner
```

### Docker
```bash
docker compose up -d
curl http://localhost:8080
```

---

## 📈 Artifacts (from CI)

| Artifact | Size | Description |
|----------|------|-------------|
| `jacoco-report` | 281 KB | HTML coverage report |
| `pitest-report` | - | HTML mutation testing report |
| `dependency-check-report` | 94.9 KB | OWASP security report |
| `jmh-benchmark-results` | - | Performance benchmark output |

---

## 📝 Conclusion

This project demonstrates a comprehensive approach to software dependability through:

1. **Automated CI/CD** - Every push triggers quality gates
2. **High Test Coverage** - 98% line coverage with JaCoCo
3. **Mutation Testing** - 70% mutation score validates test effectiveness
4. **Formal Verification** - JML specifications verified by OpenJML
5. **Performance Testing** - JMH benchmarks measure critical paths
6. **Security Scanning** - Multi-layer security analysis with no critical issues
7. **Containerization** - Production-ready Docker image on DockerHub

The methodology and tools provide a replicable framework for dependability analysis applicable to other Java applications.

---

## 📚 References

- [Spring PetClinic](https://github.com/spring-projects/spring-petclinic)
- [JaCoCo](https://www.jacoco.org/jacoco/)
- [PITest](https://pitest.org/)
- [OpenJML](https://www.openjml.org/)
- [JMH](https://openjdk.org/projects/code-tools/jmh/)
- [Snyk](https://snyk.io/)
- [OWASP Dependency-Check](https://owasp.org/www-project-dependency-check/)
- [SonarQube](https://www.sonarqube.org/)
