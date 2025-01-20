package com.database.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.database.builder.ObjectBuilder;
import com.database.entity.Student;
import com.database.entity.StudentINFO;
import com.database.entity1.Teacher;
import com.database.entity1.TeacherINFO;
import com.database.repository.StudentRepository;
import com.database.repository1.TeacherRepository;

@RestController
public class StudentTeacherRestController {

	@Autowired
	StudentRepository studentRepo;
	
	@Autowired
	TeacherRepository teacherRepo;
	
	@PostMapping("/saveStudent")
	public Student saveStudent(@RequestBody StudentINFO studentINFO) {
		Student student = ObjectBuilder.createStudentFromStudentDTO(studentINFO);
		return studentRepo.save(student);
	}
	
	@PostMapping("/saveTeacher")
	public Teacher saveTeacher(@RequestBody TeacherINFO teacherINFO) {
		Teacher teacher = ObjectBuilder.createTeacherFromTeacherDTO(teacherINFO);
		return teacherRepo.save(teacher);
	}
	
	@GetMapping("/getAllStudents")
	public List<Student> getAllStudents(){
		return studentRepo.findAll();
	}
	
	@GetMapping("/getAllTeachers")
	public List<Teacher> getAllTeachers(){
		return teacherRepo.findAll();
	}
}
