package com.clean.code.domain.school;

import java.util.Optional;

import com.clean.code.domain.usecase.expection.BusinessException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SchoolUseCase {

	private final SchoolProvider schoolProvider;
	
	public School create(School school) {
		Optional<School> schoolById = schoolProvider.findById(school.getId());
		if (schoolById.isPresent()) {
			throw new BusinessException(school.getId().toString() + " duplicate");
		}
		return schoolProvider.add(school);
	}

}
