package com.ss.userManagementDB.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.userManagementDB.dto.Student;
import com.ss.userManagementDB.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public List<Student> getAllStudent() {
		List<Student> studentList = (List<Student>)studentRepository.findAll();
		return studentList;
	}

	@Override
	public void addStudent(Student student) {
		studentRepository.save(student);
	}

}
