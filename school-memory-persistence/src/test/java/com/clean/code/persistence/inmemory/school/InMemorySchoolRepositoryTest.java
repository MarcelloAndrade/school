package com.clean.code.persistence.inmemory.school;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.clean.code.domain.school.EnumLevel;
import com.clean.code.domain.school.School;

class InMemorySchoolRepositoryTest {

	private InMemorySchoolRepository repository;
	private School school;

	@BeforeEach
	void setUp() {
		repository = new InMemorySchoolRepository();
		school = School.builder()
					   .id(UUID.randomUUID())
					   .name("FATEC -  Faculdades de Tecnologia do Estado de São Paulo")
					   .level(Arrays.asList(EnumLevel.ENSINO_INFANTIL, EnumLevel.ENSINO_MEDIO))
					   .build();
	}

	@Test
	void addSchool() {
		assertEquals(repository.add(school), school);
		assertEquals(repository.getInMemorySchool(), Arrays.asList(school));
	}

	@Test
	void findExistingSchool() {
		repository.add(school);
		assertEquals(repository.findById(school.getId()), Optional.of(school));
	}

	@Test
	void findAllEmptySchool() {
		assertTrue(repository.findAll().isEmpty());
	}
	
	@Test
	void findAllSchool() {
		repository.add(school);
		assertIterableEquals(repository.findAll(), Arrays.asList(school));
	}

}