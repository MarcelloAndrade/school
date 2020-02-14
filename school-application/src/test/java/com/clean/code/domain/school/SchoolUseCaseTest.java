package com.clean.code.domain.school;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.clean.code.domain.school.School.EnumLevel;

@ExtendWith(MockitoExtension.class)
class SchoolUseCaseTest {

	private SchoolUseCase useCase;

	@Mock
	private SchoolProvider schoolProviderMock;
	private School school;
	private UUID schoolId;

	@BeforeEach
	void setUp() {
		useCase = new SchoolUseCase(schoolProviderMock);
		schoolId = UUID.randomUUID();
		school = School.builder()
							.id(schoolId)
							.name("FATEC -  Faculdades de Tecnologia do Estado de S�o Paulo")
							.level(Arrays.asList(EnumLevel.ENSINO_SUPERIOR))
							.build();
	}

	@Test
	void createSchoolExisting_ThrowsException() {
		when(schoolProviderMock.findById(schoolId)).thenReturn(Optional.of(school));
		assertThrows(IllegalArgumentException.class, () -> useCase.create(school));
	}

	@Test
	void createSchool_Success() {
		when(schoolProviderMock.findById(schoolId)).thenReturn(Optional.empty());
		when(schoolProviderMock.add(school)).thenReturn(school);
		assertEquals(useCase.create(school), school);
	}
}