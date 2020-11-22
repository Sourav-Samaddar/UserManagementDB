package com.ss.userManagementDB.service;

import java.util.List;

import com.ss.userManagementDB.dto.Vehicle;

public interface VehicleService {

	void addVehicle(Vehicle vehicle);
	
	List<Vehicle> getAllVehicle();
}
