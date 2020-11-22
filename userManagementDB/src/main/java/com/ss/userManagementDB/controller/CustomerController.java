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

import com.ss.userManagementDB.dto.Customer;
import com.ss.userManagementDB.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/allCustomers")
	public List<Customer> getAllCustomer(){
		return customerService.findAllCustomer();
	}
	
	@PostMapping("/addCustomer")
	public ResponseEntity<Object> addCustomer(@RequestBody Customer customer) {
		customerService.addCustomer(customer);
		URI path = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(customer).toUri();
		
		return ResponseEntity.created(path).build();
	}
}
