package com.ss.userManagementDB.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ss.userManagementDB.dto.Student;
import com.ss.userManagementDB.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping("/findAllStudent")
	public List<Student> getAllStudent(){
		return studentService.getAllStudent();
	}
	
	@PostMapping("/addStudent")
	public ResponseEntity<Object> addStudent(@RequestBody Student student){
		studentService.addStudent(student);
		URI path = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(student.getId()).toUri();
		
		return ResponseEntity.created(path).build();
	}
}
