# Presentation Slides - Software Dependability Project
## Spring PetClinic Dependability Analysis

**Author:** Bekhruzjon Hakmirzaev (NF22500050)  
**Course:** Software Dependability  
**Professor:** Dario Di Nucci  
**University:** University of Salerno

---

## Slide 1: Title Slide

# Dependability Analysis of Spring PetClinic
## A Comprehensive Study Using Modern Software Engineering Practices

**Bekhruzjon Hakmirzaev**  
University of Salerno | Master in Internet of Things  
Department of Computer Engineering

**Course:** Software Dependability | **Professor:** Dario Di Nucci | **Matricola:** NF22500050

---

## Slide 2: Introduction

### Project Subject: Spring PetClinic
- Reference implementation for Spring Boot applications
- Veterinary clinic management system

### Goal
Comprehensive dependability analysis using modern software engineering practices

### Approach: Multi-faceted Quality Assurance
- Automated testing and coverage
- Mutation testing
- Formal verification
- Security analysis
- Performance benchmarking

---

## Slide 3: Project Objectives

1. Establish robust CI/CD pipeline with automated quality gates
2. Achieve comprehensive test coverage using JaCoCo
3. Assess test effectiveness through mutation testing (PITest)
4. Apply formal verification using JML and OpenJML
5. Measure performance with JMH microbenchmarks
6. Identify vulnerabilities using multiple security scanners
7. Containerize application for deployment

**Repository:** github.com/hakmirzaev/spring-petclinic  
**DockerHub:** hakmirzaev/spring-petclinic:latest

---

## Slide 4: Methodology - CI/CD Pipeline

### GitHub Actions Workflow
- **build-test** - Tests + JaCoCo + PITest
- **benchmarks** - JMH Performance
- **security-snyk** - Dependency Scan
- **security-dependency-check** - OWASP
- **sonarqube** - Code Quality
- **docker-push** - Container Registry

### Tools Integrated
- JaCoCo - Code Coverage
- PITest - Mutation Testing
- OpenJML - Formal Verification
- JMH - Performance Benchmarks
- Snyk - Security Scanning
- OWASP - CVE Analysis
- SonarQube - Static Analysis

*Pipeline executes automatically on every push*

---

## Slide 5: Results - Test Coverage (JaCoCo)

| Package | Line Coverage | Branch Coverage |
|---------|---------------|-----------------|
| petclinic.owner | 93% | 82% |
| petclinic.vet | **100%** | **100%** |
| petclinic.model | **100%** | **100%** |
| petclinic.system | 74% | n/a |
| **Total** | **98%** | **84%** |

- **108 methods** tested across all packages
- Comprehensive coverage of production code paths
- Critical packages (vet, model) achieve 100% coverage

---

## Slide 6: Results - Mutation Testing (PITest)

### Mutation Analysis
- **143 mutations** generated
- **100 mutations** killed
- **Mutation Score: 70%**
- **Test Strength: 76%**
- **301 tests** executed

### Interpretation
- Test suite effectively detects most code changes
- 70% score indicates good test quality
- 30% surviving mutations suggest opportunities for improvement
- Areas for enhancement: edge case testing

*Mutation testing validates that tests catch real bugs*

---

## Slide 7: Formal Verification & Security

### JML Formal Verification
- **11 classes** annotated with JML
- **3 classes** ESC verified successfully
- Type checking passed for all files
- Method contracts verified

### Security Analysis
- ✅ **Snyk:** No high/critical vulnerabilities
- ✅ **OWASP:** No CVEs above threshold
- ✅ **SonarQube:** No security hotspots
- **Result:** Clean security posture

*Multi-layered security approach ensures application safety*

---

## Slide 8: Key Findings

1. **High Test Coverage:** 98% line coverage demonstrates thorough testing
2. **Effective Mutation Testing:** 70% mutation score validates test quality
3. **Formal Verification:** JML specifications successfully verify domain properties
4. **Security Posture:** No critical vulnerabilities across all scanning tools
5. **Container Ready:** Application fully containerized and available on DockerHub
6. **CI/CD Integration:** All quality gates automated in pipeline

---

## Slide 9: Conclusion

- Comprehensive dependability analysis successfully completed

- **All 10 evaluation criteria satisfied:**
  - CI/CD pipeline operational
  - High test coverage (98%)
  - Mutation testing (70% score)
  - Formal verification with JML
  - Security scans clean
  - Docker image published

- **Methodology provides replicable framework** for dependability analysis

- **Results demonstrate:** Systematic approach improves code quality and reliability

---

## Thank You!

**Questions?**

---

## Backup Slides (if needed)

### CI/CD Pipeline Metrics
- **Total Duration:** 31m 12s
- **Jobs:** 6 parallel jobs
- **Status:** All jobs passed ✅

### Detailed Metrics
- **Tests:** 50+ unit tests
- **JML Classes:** 11 annotated, 3 ESC verified
- **Benchmarks:** 4 benchmark classes
- **Security Tools:** Snyk, OWASP, SonarQube
