package com.ss.userManagementDB.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ss.userManagementDB.dto.Vehicle;
import com.ss.userManagementDB.service.VehicleService;

@RestController
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;
	
	@GetMapping("/allVehicles")
	public List<Vehicle> getAllVehicle(){
		return vehicleService.getAllVehicle();
	}
	
	@PostMapping("/addVehicle")
	public ResponseEntity<Object> addVehicle(Vehicle vehicle){
		vehicleService.addVehicle(vehicle);
		URI path = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(vehicle.getId()).toUri();
		
		return ResponseEntity.created(path).build();
	}
}
