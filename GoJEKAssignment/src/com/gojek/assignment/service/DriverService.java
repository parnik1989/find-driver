package com.gojek.assignment.service;

import com.gojek.assignment.model.DriverRequestDTO;

/**
 * @author parnik
 *  Service layer for driver data related operations
 *
 */
public interface DriverService {

	public void updateDriverLocation(DriverRequestDTO driverDTO);
	
}
