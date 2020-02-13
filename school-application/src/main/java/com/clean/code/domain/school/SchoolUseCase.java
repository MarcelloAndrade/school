package com.clean.code.domain.school;

import java.util.Optional;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SchoolUseCase {

	private final SchoolProvider schoolProvider;
	
	public School create(School school) {
		Optional<School> schoolById = schoolProvider.findById(school.getId());
		if (schoolById.isPresent()) {
			throw new IllegalArgumentException(school.getId().toString() + "duplicate");
		}
		return schoolProvider.add(school);
	}

}
