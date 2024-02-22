package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojo.Student;
import com.app.service.StudentService;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "http://localhost:3000")

public class StudentController {
	@Autowired
	public StudentService studSer;
	
	public StudentController() {
		System.out.println("in constr of " +getClass());
	}
	
	@GetMapping
	public List<Student> getAllStudent(){
		System.out.println("in get method");
		return studSer.getAllStudent();
	}
	
	@PostMapping
	public ResponseEntity<?>  addStudent(@RequestBody Student stud) {
		 if (stud == null) {
	          return ResponseEntity.badRequest().body("Student details cannot be null");
	        }	
		Student newStud=new Student (stud.getRollNo(),stud.getFirstName(),stud.getLastName(),stud.getEmailId(),stud.getCity());
        Student addedStudent = studSer.addStudent(newStud);
        if (addedStudent != null) {
            return ResponseEntity.ok(addedStudent);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add student");
        }
	}
	
//	@DeleteMapping("/{studId}")
//	public String deleteStudent(@PathVariable Long studId) {
//		System.out.println("in delete method");
//		return studSer.deleteStudent(studId);
//	}
	@DeleteMapping("/{studId}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long studId) {
        System.out.println("in delete method");
        String result = studSer.deleteStudent(studId);
        if (result.equals("deleted successfully")) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
    @PutMapping("/{studId}")
    public ResponseEntity<String> updateStudent(@PathVariable Long studId, @RequestBody Student stud) {
        if (stud == null) {
            return ResponseEntity.badRequest().body("Student details cannot be null");
        }
        System.out.println("in update method");
        String result = studSer.updateStudent(studId, stud);
        if (result.equals("student updated")) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}