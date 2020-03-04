package com.clean.code.persistence.mysql;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clean.code.domain.school.School;
import com.clean.code.domain.school.SchoolProvider;

@Repository
public class SchoolRepositoryImpl implements SchoolProvider {
	
	@Autowired
	private SchoolRepository repository;

	@Override
	public School add(School school) {
		repository.save(new MySqlSchool().fromDomain(school));
		return school;
	}

	@Override
	public Optional<School> findById(UUID schoolId) {
		return repository.findById(schoolId).map(MySqlSchool::toDomain);
	}

	@Override
	public List<School> findAll() {
		return repository.findAll().stream().map(MySqlSchool::toDomain).collect(Collectors.toList());
	}
}
