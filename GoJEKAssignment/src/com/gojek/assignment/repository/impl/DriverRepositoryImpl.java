package com.gojek.assignment.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gojek.assignment.model.Driver;
import com.gojek.assignment.model.UserRequestDTO;
import com.gojek.assignment.repository.DriverRepository;

@Repository(value="driverRepository")
public class DriverRepositoryImpl implements DriverRepository {

	@Autowired
    JdbcTemplate jdbcTemplate;
	
	@Override
	public void updateDriversLocation(Driver driver) {
		jdbcTemplate.update("update gojek_assignment.driver set longitude=?,latitude=?,accuracy=? where driver_id=?",
				driver.getLongitude(),driver.getLattitude(),driver.getAccuracy(),driver.getId());
		System.out.println("Driver Details updated "+driver);

	}

	@Override
	public List<Driver> getDriversList(UserRequestDTO userRequestDTO) {
		System.out.println("Getting Driver's List");
		List<Driver> driverList = jdbcTemplate.query("SELECT * FROM gojek_assignment.driver",new BeanPropertyRowMapper(Driver.class));
	 
		return driverList;
	}

	@Override
	public void saveDriverDetails(Driver driver) {
		
		jdbcTemplate.update("Insert into gojek_assignment.driver (driver_id,longitude,latitude,accuracy,submission_date) values(?,?,?,?,sysdate());",
	            driver.getId(), driver.getLongitude(), driver.getLattitude(), driver.getAccuracy());
	        	
		System.out.println("Details Saved"+driver);
	}

}
