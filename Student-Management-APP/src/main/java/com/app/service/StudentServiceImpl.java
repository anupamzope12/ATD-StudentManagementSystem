package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojo.Student;
import com.app.repository.StudentRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{

	@Autowired
	public StudentRepository studRepo;
	
	@Override
	public Student addStudent(Student stud) {
		
		return studRepo.save(stud);
	}

	@Override
	public List<Student> getAllStudent() {
		return studRepo.findAll();
	}

	@Override
	public String deleteStudent(Long studId) {
		if(studRepo.existsById(studId)) {
			studRepo.deleteById(studId);;
			return "deleted successflly";
		}else
			return "Id not found";
	}

	@Override
	public String updateStudent(Long studId, Student stud) {
		Optional<Student> existingStud=studRepo.findById(studId);
		if(existingStud.isPresent()) {
			Student exStudent=existingStud.get();
			
			exStudent.setFirstName(stud.getFirstName());
			exStudent.setLastName(stud.getLastName());
			exStudent.setEmailId(stud.getEmailId());
			exStudent.setCity(stud.getCity());
			
			studRepo.save(exStudent);
			return "student updated";
		}else {
			return "id not found";
		}
	}

}
