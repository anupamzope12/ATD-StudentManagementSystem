package com.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.pojo.Student;

import jakarta.transaction.Transactional;

@Service
@Transactional
public interface StudentService {

	Student addStudent(Student stud);
	List<Student> getAllStudent();
	String deleteStudent(Long studId);
	String updateStudent(Long studId,Student stud);
	
}
