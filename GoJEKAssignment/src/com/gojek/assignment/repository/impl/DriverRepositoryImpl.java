package com.gojek.assignment.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gojek.assignment.controller.CentralController;
import com.gojek.assignment.model.Driver;
import com.gojek.assignment.model.DriverResponseDTO;
import com.gojek.assignment.model.UserRequestDTO;
import com.gojek.assignment.repository.DriverRepository;

/**
 * @author parnik Repository Layer for driver related operations including
 * 			 update the current location of a driver and
 *         getting the list of available driver in the given distance from
 *         user's location
 */
@Repository(value = "driverRepository")
public class DriverRepositoryImpl implements DriverRepository {

	private final static Logger logger = Logger.getLogger(CentralController.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	private static String GET_DRIVERS_LIST = "SELECT  driver_id as id,longitude,latitude, ROUND((111.111 * DEGREES(ACOS(COS(RADIANS(latitude)) * COS(RADIANS(?)) "
			+ " * COS(RADIANS(longitude - ?)) + SIN(RADIANS(latitude)) * SIN(RADIANS(?))))),3) AS distance FROM gojek.driver where longitude between "
			+ " ? and ? and latitude between ? and ? ORDER BY distance DESC limit ?";

	private static String UPDATE_DRIVERS_DETAILS = "update gojek.driver set longitude=?,latitude=?,accuracy=? where driver_id=? ";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.gojek.assignment.repository.DriverRepository#updateDriversLocation(
	 * com.gojek.assignment.model.Driver)
	 * 
	 * Repository Layer to update the drivers current location
	 */
	@Override
	public void updateDriversLocation(Driver driver) throws DataAccessException{
		logger.debug("Updating drivers data");
			jdbcTemplate.update(
					UPDATE_DRIVERS_DETAILS,
					driver.getLongitude(), driver.getLatitude(), driver.getAccuracy(), driver.getId());
		

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.gojek.assignment.repository.DriverRepository#getDriversList(com.gojek
	 * .assignment.model.UserRequestDTO)
	 * 
	 * Repository Layer to get available driver details in the range given by
	 * user
	 */
	@Override
	public List<DriverResponseDTO> getDriversList(UserRequestDTO userRequestDTO) throws DataAccessException{
		// Calculating degrees in which range we need to search the drivers
		Double range = userRequestDTO.getRadius() * 0.009;

		// calculating actual range to find the drivers in between
		Double longitude_min = userRequestDTO.getLongitude() - range;
		Double longitude_max = userRequestDTO.getLongitude() + range;
		Double latitude_min = userRequestDTO.getLattitude() - range;
		Double latitude_max = userRequestDTO.getLattitude() + range;
		// DB call to get the response having driver_id, latitude,
		// longitude and Distance between user and driver in kms
		List<DriverResponseDTO> driverList = new ArrayList<DriverResponseDTO>();
			driverList = jdbcTemplate.query(GET_DRIVERS_LIST,
					new Object[] { userRequestDTO.getLattitude(), userRequestDTO.getLongitude(),
							userRequestDTO.getLattitude(), longitude_min, longitude_max, latitude_min, latitude_max,
							userRequestDTO.getLimit() },
					new BeanPropertyRowMapper<DriverResponseDTO>(DriverResponseDTO.class));
		logger.debug("Driver Details : " + driverList.size());
		// returning the nearby drivers list
		return driverList;
	}

}
