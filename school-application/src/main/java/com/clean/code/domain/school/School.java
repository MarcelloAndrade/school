package com.clean.code.domain.school;

import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class School {

	@Builder.Default
	private UUID id = UUID.randomUUID();
	private String name;
	private List<EnumLevel> level;

}
