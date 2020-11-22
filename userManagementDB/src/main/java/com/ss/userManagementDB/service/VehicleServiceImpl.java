package com.ss.userManagementDB.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.userManagementDB.dto.Vehicle;
import com.ss.userManagementDB.repository.VehicleRepository;

@Service
public class VehicleServiceImpl implements VehicleService{

	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Override
	public void addVehicle(Vehicle vehicle) {
		vehicleRepository.save(vehicle);
	}

	@Override
	public List<Vehicle> getAllVehicle() {
		return vehicleRepository.findAll();
	}

}
