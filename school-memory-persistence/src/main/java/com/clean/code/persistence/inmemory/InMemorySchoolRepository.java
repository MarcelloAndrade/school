package com.clean.code.persistence.inmemory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.clean.code.domain.school.School;
import com.clean.code.domain.school.SchoolProvider;

import lombok.Data;

@Data
public class InMemorySchoolRepository implements SchoolProvider {

	private List<School> inMemorySchool = new ArrayList<>();
	
	@Override
	public School add(School school) {
		inMemorySchool.add(school);
		return school;
	}

	@Override
	public Optional<School> findById(UUID schoolId) {
		return inMemorySchool.stream().filter(s -> s.getId().equals(schoolId)).findAny();
	}

	@Override
	public List<School> findAll() {
		return inMemorySchool;
	}

}
