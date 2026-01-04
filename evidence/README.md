# Evidence Folder

Evidence and documentation for Spring PetClinic Dependability Project.

## Structure

```
evidence/
├── docker/
│   └── dockerhub-proof.txt       # Docker Hub deployment
├── openjml/
│   ├── verification-report.txt   # JML verification
│   └── esc-full-output.txt       # ESC output
├── security/
│   └── security-analysis.md      # Security scanning
├── benchmarks/
│   └── jmh-benchmarks.md         # Performance benchmarks
└── README.md                     # This file
```

## Contents Summary

- **Docker**: Containerization and DockerHub deployment proof
- **OpenJML**: Formal verification with JML specifications
- **Security**: Vulnerability scanning (Snyk, OWASP, SonarQube)
- **Benchmarks**: JMH performance microbenchmarks

## Accessing CI Artifacts

1. GitHub → Actions → CI workflow run
2. Download artifacts:
   - jacoco-report (coverage)
   - pitest-report (mutation testing)
   - jmh-benchmark-results (performance)
   - Security reports (if configured)

## Last Updated

January 4, 2026
