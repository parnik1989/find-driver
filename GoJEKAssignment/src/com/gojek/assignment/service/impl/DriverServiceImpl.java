package com.gojek.assignment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gojek.assignment.model.DriverRequestDTO;
import com.gojek.assignment.repository.DriverRepository;
import com.gojek.assignment.service.DriverService;

@Service(value="driverService")
public class DriverServiceImpl implements DriverService {

	@Autowired
	DriverRepository driverRepository;
	
	@Override
	public Long saveDriverDetails(DriverRequestDTO driverDTO) {
		System.out.println("Saving current driver location");
		driverRepository.updateDriversLocation(driverDTO);
		return driverDTO.getUserId();
	}

	@Override
	public DriverRequestDTO getDriverDetailsById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DriverRequestDTO> getNearByDriversList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long updateDriverLocation(DriverRequestDTO driverDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
