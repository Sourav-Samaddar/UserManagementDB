package com.ss.userManagementDB.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.userManagementDB.dto.Customer;
import com.ss.userManagementDB.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public List<Customer> findAllCustomer() {
		List<Customer> customerList = (List<Customer>)customerRepository.findAll();
		return customerList;
	}

	@Override
	public void addCustomer(Customer customer) {
		customerRepository.save(customer);
	}

}
