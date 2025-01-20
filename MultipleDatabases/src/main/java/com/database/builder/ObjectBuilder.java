package com.database.builder;

import com.database.entity.Student;
import com.database.entity.StudentINFO;
import com.database.entity1.Teacher;
import com.database.entity1.TeacherINFO;

public class ObjectBuilder {

	public  static Student createStudentFromStudentDTO(StudentINFO studentDTO) {
		Student student = new Student();
		student.setName(studentDTO.getName());
		student.setSchoolName(studentDTO.getSchoolName());
		student.setStandard(studentDTO.getStandard());
		return student;
	}

	
	public static  Teacher createTeacherFromTeacherDTO(TeacherINFO teacherDTO) {
		
		Teacher teacher = new Teacher();
		teacher.setName(teacherDTO.getName());
		teacher.setSubject(teacherDTO.getSubject());
		return teacher;
	}
}
