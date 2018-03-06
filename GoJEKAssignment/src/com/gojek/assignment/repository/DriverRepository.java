package com.gojek.assignment.repository;

import java.util.List;

import com.gojek.assignment.model.Driver;
import com.gojek.assignment.model.UserRequestDTO;

/**
 * @author parnik
 *
 */
public interface DriverRepository {

	public void updateDriversLocation(Driver driver);
	public List<Driver> getDriversList(UserRequestDTO userRequestDTO);
	public void saveDriverDetails(Driver driver);
	
}
