package com.clean.code.persistence.mysql;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.clean.code.domain.school.EnumLevel;
import com.clean.code.domain.school.School;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_school")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MySqlSchool {

	@Id
	private UUID id;
	private String name;
	private List<EnumLevel> level;
	

	public MySqlSchool fromDomain(School school) {
		return new MySqlSchool(school.getId(), school.getName(), school.getLevel());
	}

	public School toDomain() {
		return new School(this.id, this.name, this.level);
	}
}
