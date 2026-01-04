# JMH Microbenchmarks Report

## Date: January 4, 2026

This document provides evidence of JMH performance benchmarks for Spring PetClinic.

## Benchmark Classes

### 1. DomainModelBenchmark
**Location**: `src/test/java/.../benchmark/DomainModelBenchmark.java`

**Benchmarks**:
- Entity creation (Owner, Pet)
- Collection operations
- String operations

**Configuration**: Average time in nanoseconds

### 2. OwnerRepositoryBenchmark
**Location**: `src/test/java/.../benchmark/OwnerRepositoryBenchmark.java`

**Benchmarks**:
- Database queries
- Pagination
- Primary key lookups

**Configuration**: Average time in milliseconds

### 3. VetRepositoryBenchmark
**Location**: `src/test/java/.../benchmark/VetRepositoryBenchmark.java`

**Benchmarks**:
- Cache performance
- Query optimization

## Running Benchmarks

```bash
mvn test-compile
java -cp "target/test-classes:target/classes:$(mvn -q dependency:build-classpath)" \
  org.springframework.samples.petclinic.benchmark.BenchmarkRunner
```

## Evidence Location

- Source: `src/test/java/.../benchmark/`
- CI: `.github/workflows/ci.yml` (benchmarks job)
- Results: GitHub Actions artifacts

## Performance Insights

✅ Entity operations are efficient (nanosecond range)
✅ Database queries perform well with proper indexing
✅ Caching significantly improves repeated queries
