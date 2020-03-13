package com.clean.code.persistence.mysql.school;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.clean.code.domain.school.School;

//@RunWith(SpringRunner.class)
//@SpringBootTest
//@Configuration
//@ActiveProfiles(value = "test")

//@SpringBootTest(classes = MySqlSchoolRepositoryTest.class)
@RunWith(SpringRunner.class)
@DataJpaTest
//@ActiveProfiles(value = "test")
public class MySqlSchoolRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private SchoolRepository schoolRepository;

//	private SchoolRepositoryImpl repositoryImpl;
	
	@Test
	void injectedComponentsAreNotNull() {
		assertThat(entityManager).isNotNull();
	}

	@Test
	void whenFindByName_thenReturnEmployee() {
		School school = School.builder().name("Piloto").build();
		entityManager.persist(school);
		entityManager.flush();

		// when
		Optional<MySqlSchool> found = schoolRepository.findById(school.getId());

		// then
		assertThat(found.get().getName()).isEqualTo(school.getName());
	}
}
