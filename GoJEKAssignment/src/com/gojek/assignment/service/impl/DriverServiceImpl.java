package com.gojek.assignment.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.gojek.assignment.controller.CentralController;
import com.gojek.assignment.model.Driver;
import com.gojek.assignment.model.DriverRequestDTO;
import com.gojek.assignment.repository.DriverRepository;
import com.gojek.assignment.service.DriverService;

/**
 * @author parnik 
 * 
 * Service layer for driver related operations includes saving
 *         the driver data and updating drivers current location
 */
@Service(value = "driverService")
public class DriverServiceImpl implements DriverService {

	@Autowired
	DriverRepository driverRepository;

	private final static Logger logger = Logger.getLogger(CentralController.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.gojek.assignment.service.DriverService#updateDriverLocation(com.gojek
	 * .assignment.model.DriverRequestDTO) updates the driver's current location
	 */
	@Override
	public void updateDriverLocation(DriverRequestDTO driverDTO) throws DataAccessException{
		logger.debug("Service Layer Update driver location");
		driverRepository.updateDriversLocation(getDriverEntity(driverDTO));
	}

	private Driver getDriverEntity(DriverRequestDTO driverRequestDTO) {
		Driver driver = new Driver();
		driver.setId(driverRequestDTO.getUserId());
		driver.setAccuracy(driverRequestDTO.getAccuracy());
		driver.setLatitude(driverRequestDTO.getLatitude());
		driver.setLongitude(driverRequestDTO.getLongitude());

		return driver;
	}

}
