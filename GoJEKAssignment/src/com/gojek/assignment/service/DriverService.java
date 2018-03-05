package com.gojek.assignment.service;

import java.util.List;

import com.gojek.assignment.model.DriverRequestDTO;

public interface DriverService {

	public Long saveDriverDetails(DriverRequestDTO driverDTO);
	public Long updateDriverLocation(DriverRequestDTO driverDTO);
	public DriverRequestDTO getDriverDetailsById();
	public List<DriverRequestDTO> getNearByDriversList();
}
