package com.clean.code.domain.school;

import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
public class School {

	@Builder.Default
	private UUID id = UUID.randomUUID();
	private String name;
	private List<EnumLevel> level;
	
	@Getter
	@AllArgsConstructor
	enum EnumLevel {		
		ENSINO_INFANTIL("Ensino Infantil"),
		ENSINO_FUNDAMENTAL("Ensino Fundamental"),
		ENSINO_MEDIO("Ensino Médio"),
		ENSINO_SUPERIOR("Ensino Superior");
		
		private String name;
		
		public static void main(String[] args) {
			System.out.println(EnumLevel.ENSINO_FUNDAMENTAL.name);
		}
	}

}
