package com.gojek.assignment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gojek.assignment.model.Driver;
import com.gojek.assignment.model.DriverRequestDTO;
import com.gojek.assignment.repository.DriverRepository;
import com.gojek.assignment.service.DriverService;

@Service(value = "driverService")
public class DriverServiceImpl implements DriverService {

	@Autowired
	DriverRepository driverRepository;

	@Override
	public Long saveDriverDetails(DriverRequestDTO driverDTO) {
		System.out.println("Saving current driver location");
		driverRepository.saveDriverDetails(getDriverEntity(driverDTO));
		return driverDTO.getUserId();
	}

	@Override
	public Long updateDriverLocation(DriverRequestDTO driverDTO) {
		driverRepository.updateDriversLocation(getDriverEntity(driverDTO));
		return null;
	}
	
	private Driver getDriverEntity(DriverRequestDTO driverRequestDTO){
		Driver driver = new Driver();
		driver.setId(driverRequestDTO.getUserId());
		driver.setAccuracy(driverRequestDTO.getAccuracy());
		driver.setLattitude(driverRequestDTO.getLattitude());
		driver.setLongitude(driverRequestDTO.getLongitude());
		
		return driver;
	}

}
