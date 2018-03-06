package com.gojek.assignment.service;

import com.gojek.assignment.model.DriverRequestDTO;

public interface DriverService {

	public Long saveDriverDetails(DriverRequestDTO driverDTO);
	public Long updateDriverLocation(DriverRequestDTO driverDTO);
	
}
