package com.database.repository1;

import org.springframework.data.jpa.repository.JpaRepository;

import com.database.entity1.Teacher;

public interface TeacherRepository  extends JpaRepository<Teacher, Integer> {

}
