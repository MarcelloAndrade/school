package com.clean.code.persistence.mysql;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

interface SchoolRepository extends JpaRepository<MySqlSchool, UUID> {

}
