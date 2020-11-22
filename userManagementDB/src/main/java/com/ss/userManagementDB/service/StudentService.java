package com.ss.userManagementDB.service;

import java.util.List;

import com.ss.userManagementDB.dto.Student;

public interface StudentService {

	List<Student> getAllStudent();
	
	void addStudent(Student student);
}
