package com.ss.userManagementDB.service;

import java.util.List;

import com.ss.userManagementDB.dto.Customer;

public interface CustomerService {

	List<Customer> findAllCustomer();
	
	void addCustomer(Customer customer);
}
