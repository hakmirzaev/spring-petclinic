/*
 * Copyright 2012-2025 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.petclinic.benchmark;

import java.io.File;

import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * Main class to run all JMH benchmarks for the PetClinic application. This runner
 * executes performance benchmarks on the most demanding components.
 *
 * @author Dependability Project
 */
public class BenchmarkRunner {

	public static void main(String[] args) throws RunnerException {
		// Create output directory
		new File("target/benchmark-results").mkdirs();

		Options opt = new OptionsBuilder().include(".*Benchmark.*")
			.resultFormat(ResultFormatType.JSON)
			.result("target/benchmark-results/jmh-results.json")
			.forks(1)
			.warmupIterations(2)
			.measurementIterations(3)
			.build();

		System.out.println("==============================================");
		System.out.println("Starting JMH Benchmarks for Spring PetClinic");
		System.out.println("==============================================");

		new Runner(opt).run();

		System.out.println("==============================================");
		System.out.println("Benchmarks complete. Results saved to:");
		System.out.println("target/benchmark-results/jmh-results.json");
		System.out.println("==============================================");
	}

}
