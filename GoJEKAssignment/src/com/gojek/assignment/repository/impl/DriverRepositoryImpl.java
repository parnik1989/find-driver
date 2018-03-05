package com.gojek.assignment.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.gojek.assignment.model.DriverRequestDTO;
import com.gojek.assignment.model.DriverResponseDTO;
import com.gojek.assignment.model.UserRequestDTO;
import com.gojek.assignment.repository.DriverRepository;

@Repository(value="driverRepository")
public class DriverRepositoryImpl implements DriverRepository {

	@Override
	public void updateDriversLocation(DriverRequestDTO driverRequestDTO) {
		
		System.out.println("DriverDetails saved"+driverRequestDTO);

	}

	@Override
	public List<DriverResponseDTO> getDriversList(UserRequestDTO userRequestDTO) {
		System.out.println("Getting Driver's List");
		List<DriverResponseDTO> availableDrivers=new ArrayList<DriverResponseDTO>();
		availableDrivers.add(new DriverResponseDTO());
		availableDrivers.add(new DriverResponseDTO());
		availableDrivers.add(new DriverResponseDTO());
		return availableDrivers;
	}

}
