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

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.owner.Pet;
import org.springframework.samples.petclinic.owner.PetType;
import org.springframework.samples.petclinic.owner.Visit;

/**
 * JMH Benchmark for domain model operations. Tests the performance of entity creation,
 * manipulation, and collection operations without database access.
 *
 * @author Dependability Project
 */
@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Fork(value = 1, warmups = 0)
@Warmup(iterations = 3, time = 1)
@Measurement(iterations = 5, time = 1)
public class DomainModelBenchmark {

	private Owner owner;

	private Pet pet;

	private PetType petType;

	@Setup
	public void setup() {
		owner = new Owner();
		owner.setId(1);
		owner.setFirstName("John");
		owner.setLastName("Doe");
		owner.setAddress("123 Main St");
		owner.setCity("Springfield");
		owner.setTelephone("1234567890");

		petType = new PetType();
		petType.setId(1);
		petType.setName("Dog");

		pet = new Pet();
		pet.setId(1);
		pet.setName("Buddy");
		pet.setType(petType);
		pet.setBirthDate(LocalDate.of(2020, 1, 15));
	}

	/**
	 * Benchmark: Create new Owner entity.
	 */
	@Benchmark
	public void createOwner(Blackhole bh) {
		Owner newOwner = new Owner();
		newOwner.setFirstName("Jane");
		newOwner.setLastName("Smith");
		newOwner.setAddress("456 Oak Ave");
		newOwner.setCity("Riverside");
		newOwner.setTelephone("0987654321");
		bh.consume(newOwner);
	}

	/**
	 * Benchmark: Create new Pet entity.
	 */
	@Benchmark
	public void createPet(Blackhole bh) {
		Pet newPet = new Pet();
		newPet.setName("Max");
		newPet.setType(petType);
		newPet.setBirthDate(LocalDate.now());
		bh.consume(newPet);
	}

	/**
	 * Benchmark: Add pet to owner.
	 */
	@Benchmark
	public void addPetToOwner(Blackhole bh) {
		Owner newOwner = new Owner();
		Pet newPet = new Pet();
		newPet.setName("Test");
		newOwner.addPet(newPet);
		bh.consume(newOwner.getPets());
	}

	/**
	 * Benchmark: Add visit to pet.
	 */
	@Benchmark
	public void addVisitToPet(Blackhole bh) {
		Pet newPet = new Pet();
		Visit visit = new Visit();
		visit.setDate(LocalDate.now());
		visit.setDescription("Checkup");
		newPet.addVisit(visit);
		bh.consume(newPet.getVisits());
	}

	/**
	 * Benchmark: Owner toString (tests string concatenation performance).
	 */
	@Benchmark
	public void ownerToString(Blackhole bh) {
		bh.consume(owner.toString());
	}

	/**
	 * Benchmark: Check if entity is new.
	 */
	@Benchmark
	public void isNewCheck(Blackhole bh) {
		Owner newOwner = new Owner();
		bh.consume(newOwner.isNew());
		bh.consume(owner.isNew());
	}

}
