package com.gojek.assignment.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.gojek.assignment.controller.CentralController;
import com.gojek.assignment.model.ResponseDTO;
import com.gojek.assignment.model.UserRequestDTO;
import com.gojek.assignment.repository.DriverRepository;
import com.gojek.assignment.service.UserService;

/**
 * @author parnik
 * 
 *         Service layer to set the default values for drivers search by user
 *         and get the near by drivers
 *
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {

	@Autowired
	DriverRepository driverRepository;

	private final static Logger logger = Logger.getLogger(CentralController.class);

	@Override
	public List<ResponseDTO> findDrivers(UserRequestDTO userRequestDTO) throws DataAccessException{
		// Setting the default radius to 500 meters
		if (ObjectUtils.isEmpty(userRequestDTO.getRadius())) {
			logger.debug("Default range set to 500 meters");
			userRequestDTO.setRadius(0.5);
		}
		// Setting the default number of drivers result to 10
		if (ObjectUtils.isEmpty(userRequestDTO.getLimit())) {
			logger.debug("Default limit set to 10 drivers");
			userRequestDTO.setLimit(10L);
		}
		// Getting the requested drivers list and converting it to the desired
		// response DTO
		logger.debug("Service Layer Getting the nearby driver list");
		List<ResponseDTO> responseList = new ArrayList<ResponseDTO>(driverRepository.getDriversList(userRequestDTO));

		return responseList;
	}

}
