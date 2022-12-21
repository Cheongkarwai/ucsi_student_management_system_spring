package com.ucsi_sis.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ucsi.dto.StudentDto;
import com.ucsi_sis.entity.Student;
import com.ucsi_sis.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	private StudentService studentService;
	
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@GetMapping
	public HttpEntity<?> getAllStudents(){
		
		return ResponseEntity.ok(studentService.getAllStudents());
	}
	
	@GetMapping("/{id}")
	public HttpEntity<?> getStudentById(@PathVariable String id){
		
		return ResponseEntity.ok(studentService.getStudentById(id));
	}
	
	@PutMapping("/{id}")
	public HttpEntity<?> updateStudentById(@PathVariable String id,@RequestBody Student student){
		studentService.updateStudent(student,id);
		return ResponseEntity.ok("Hi");
	}
	
	@DeleteMapping("/{id}")
	public HttpEntity<?> deleteStudentById(@PathVariable String id){
		studentService.deleteStudentById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	@GetMapping("/{id}/profile")
	public HttpEntity<?> getStudentProfile(@PathVariable String id){
		
		return ResponseEntity.ok(studentService.getStudentProfileById(id));
	}
	@PostMapping
	public HttpEntity<?> saveStudent(@RequestBody Student student){
		studentService.saveStudent(student);
		return ResponseEntity.ok(studentService.getStudentById(student.getId()));
	}
	@PutMapping
	public HttpEntity<?> updateStudent(@RequestBody Student student){
		
		return null;
	}
	
}
