package com.gojek.assignment.repository;

import java.util.List;

import com.gojek.assignment.model.Driver;
import com.gojek.assignment.model.DriverResponseDTO;
import com.gojek.assignment.model.UserRequestDTO;

/**
 * @author parnik
 * Driver Repository layer interface to save , update and fetch details from drivers table
 */
public interface DriverRepository {

	public void updateDriversLocation(Driver driver);
	public List<DriverResponseDTO> getDriversList(UserRequestDTO userRequestDTO);
	public void saveDriverDetails(Driver driver);
	
}
