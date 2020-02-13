package com.clean.code.domain.school;

import java.util.List;
import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class School {

	@Builder.Default
	private UUID id = UUID.randomUUID();
	private String name;
	private List<EnumLevel> level;

}
