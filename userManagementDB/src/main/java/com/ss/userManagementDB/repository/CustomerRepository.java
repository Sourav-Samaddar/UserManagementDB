package com.ss.userManagementDB.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ss.userManagementDB.dto.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
