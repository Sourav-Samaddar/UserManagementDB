package com.ss.userManagementDB.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ss.userManagementDB.dto.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
