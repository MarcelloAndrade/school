package com.clean.code.domain.school;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnumLevel {		
	ENSINO_INFANTIL("Ensino Infantil"),
	ENSINO_FUNDAMENTAL("Ensino Fundamental"),
	ENSINO_MEDIO("Ensino Médio"),
	ENSINO_SUPERIOR("Ensino Superior");
	
	private String name;
	
	public static void main(String[] args) {
		System.out.println(EnumLevel.ENSINO_FUNDAMENTAL.name);
	}
}
