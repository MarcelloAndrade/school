package com.clean.code.domain.school;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SchoolProvider {

	School add(School school);

	void delete(UUID schoolId);

	Optional<School> findById(UUID schoolId);

	List<School> findAll();

}
