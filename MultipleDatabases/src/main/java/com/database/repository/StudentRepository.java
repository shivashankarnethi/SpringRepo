package com.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.database.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
