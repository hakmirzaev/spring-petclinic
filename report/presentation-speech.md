# Presentation Speech Script
## Software Dependability Project - Spring PetClinic
**Duration: 4 minutes (approximately 26-30 seconds per slide)**

---

## Slide 1: Title Slide (5 seconds)
**"Good morning/afternoon Professor Di Nucci. I'm Bekhruzjon Hakmirzaev, matricola NF22500050, and I'm presenting my Software Dependability project on Spring PetClinic."**

---

## Slide 2: Introduction (25 seconds)
**"The Spring PetClinic application is a reference implementation for Spring Boot-based web applications, specifically a veterinary clinic management system. My project goal was to conduct a comprehensive dependability analysis using modern software engineering practices. I applied a multi-faceted approach that includes automated testing and coverage analysis, mutation testing to assess test quality, formal verification using JML specifications, comprehensive security analysis, and performance benchmarking. This ensures the application meets high standards of reliability, security, and maintainability."**

---

## Slide 3: Project Objectives (25 seconds)
**"My project had seven main objectives. First, establish a robust CI/CD pipeline with automated quality gates. Second, achieve comprehensive test coverage using JaCoCo. Third, assess test effectiveness through mutation testing with PITest. Fourth, apply formal verification using JML and OpenJML. Fifth, measure performance with JMH microbenchmarks. Sixth, identify vulnerabilities using multiple security scanners. And seventh, containerize the application for deployment. All project artifacts are available on GitHub, and the Docker image is published on DockerHub."**

---

## Slide 4: Methodology - CI/CD Pipeline (30 seconds)
**"I implemented a comprehensive GitHub Actions workflow that executes automatically on every push. The pipeline consists of six parallel jobs: build-test runs tests and generates coverage reports, benchmarks execute performance tests, security-snyk scans dependencies, security-dependency-check performs OWASP analysis, sonarqube conducts static code analysis, and docker-push publishes the container image. As you can see in this code snippet, the workflow is defined in YAML format, with each job containing specific steps. For example, the build-test job runs Maven commands to execute tests with JaCoCo coverage and PITest mutation testing. I integrated industry-standard tools including JaCoCo for coverage, PITest for mutation testing, OpenJML for formal verification, JMH for benchmarks, and multiple security scanners. This ensures every code change is automatically validated."**

---

## Slide 5: Results - Test Coverage (28 seconds)
**"JaCoCo analysis reveals excellent test coverage results. The total line coverage is 98 percent, with branch coverage at 84 percent. Critical packages like vet and model achieve 100 percent coverage, while the owner package reaches 93 percent line coverage. Overall, 108 methods were tested across all packages. Here you can see a simple example of one of our test cases - this test verifies that the owner repository correctly retrieves an owner by ID. This demonstrates comprehensive testing of production code paths, ensuring that the majority of the codebase is validated by automated tests."**

---

## Slide 6: Results - Mutation Testing (25 seconds)
**"PITest mutation analysis demonstrates the effectiveness of our test suite. We generated 143 mutations, of which 100 were killed by tests, resulting in a 70 percent mutation score and 76 percent test strength. This means our tests effectively detect most code changes, validating that the test suite catches real bugs. The 30 percent of surviving mutations indicate opportunities for improvement, particularly in edge case testing. Overall, 301 tests were executed during mutation analysis."**

---

## Slide 7: Formal Verification & Security (32 seconds)
**"For formal verification, I annotated 11 classes with JML specifications, and successfully verified 3 classes using Extended Static Checking. Here you can see a concrete example of JML annotations - the getId method has a postcondition ensuring it returns the id field, and the isNew method specifies that it returns true if and only if id is null. These annotations are verified by OpenJML using SMT solvers. All files passed type checking, confirming that method contracts are consistent with implementation. For security analysis, I used three tools: Snyk found no high or critical vulnerabilities, OWASP Dependency Check reported no CVEs above threshold, and SonarQube identified no security hotspots. The Docker Compose configuration shown here ensures proper service dependencies and health checks. This multi-layered security approach ensures the application maintains a clean security posture."**

---

## Slide 8: Key Findings (25 seconds)
**"The key findings demonstrate the success of this comprehensive approach. We achieved 98 percent line coverage, validating thorough testing. The 70 percent mutation score confirms effective test quality. Formal verification successfully validated domain properties. Security scans across all tools found no critical vulnerabilities. The application is fully containerized and available on DockerHub. And all quality gates are automated in the CI/CD pipeline. These results show that a systematic approach significantly improves code quality and reliability."**

---

## Slide 9: Conclusion (20 seconds)
**"In conclusion, I successfully completed a comprehensive dependability analysis of Spring PetClinic. All 10 evaluation criteria have been satisfied, including CI/CD pipeline, test coverage, mutation testing, formal verification, security analysis, and Docker deployment. The methodology I developed provides a replicable framework that can be applied to other Java applications. The results demonstrate that systematic quality assurance practices significantly improve software dependability. Thank you for your attention."**

---

## Timing Summary
- **Slide 1:** 5 seconds
- **Slide 2:** 28 seconds
- **Slide 3:** 28 seconds
- **Slide 4:** 30 seconds (includes code explanation)
- **Slide 5:** 28 seconds (includes test example)
- **Slide 6:** 28 seconds
- **Slide 7:** 32 seconds (includes JML and Docker examples)
- **Slide 8:** 28 seconds
- **Slide 9:** 25 seconds
- **Total:** ~4 minutes

---

## Tips for Delivery
1. **Speak clearly and at a moderate pace** - Don't rush, but stay within time limits
2. **Emphasize key numbers** - 98% coverage, 70% mutation score, 0 vulnerabilities
3. **Make eye contact** - Look at the professor while speaking
4. **Use gestures** - Point to specific metrics on slides when relevant
5. **Practice transitions** - Smooth transitions between slides
6. **Be confident** - You've completed all requirements successfully!

---

## Backup Information (if asked questions)
- **CI Pipeline Duration:** 31 minutes 12 seconds
- **Total Tests:** 50+ unit tests
- **JML Classes:** 11 annotated, 3 ESC verified
- **Benchmarks:** 4 benchmark classes covering domain model and repositories
- **Docker Image:** Multi-stage build, available on DockerHub
- **Security Tools:** Snyk, OWASP Dependency Check, SonarQube
