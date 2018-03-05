package com.gojek.assignment.repository;

import java.util.List;

import com.gojek.assignment.model.DriverRequestDTO;
import com.gojek.assignment.model.DriverResponseDTO;
import com.gojek.assignment.model.UserRequestDTO;

/**
 * @author parnik
 *
 */
public interface DriverRepository {

	public void updateDriversLocation(DriverRequestDTO driverRequestDTO);
	public List<DriverResponseDTO> getDriversList(UserRequestDTO userRequestDTO);
	
}
