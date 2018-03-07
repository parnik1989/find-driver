package com.gojek.assignment.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gojek.assignment.model.DriverRequestDTO;
import com.gojek.assignment.model.FailureResponseDTO;
import com.gojek.assignment.model.ResponseDTO;
import com.gojek.assignment.model.UserRequestDTO;
import com.gojek.assignment.service.DriverService;
import com.gojek.assignment.service.UserService;

/**
 * @author parnik Rest Controller to save the details and fetch the drivers
 *         details requested by User
 *
 */
@RestController
public class CentralController {

	@Autowired
	DriverService driverService;
	@Autowired
	UserService userService;

	private final static Logger logger = Logger.getLogger(CentralController.class);

	@RequestMapping(path = "/")
	public String welcome() {
		logger.debug("WebApplication Started and default method is initiated");

		return "Welcome to Find My Driver. Please use relevant URLs with respective"
				+ " parameters to get nearby driver details";
	}

	/*
	 * Rest controller to update the driver location
	 */
	@RequestMapping(path = "/drivers/{id}/location", method = RequestMethod.PUT)
	public ResponseEntity<List<ResponseDTO>> updateDriverLocation(@PathVariable Long id,
			@RequestBody DriverRequestDTO driverRequestDTO) {
		logger.debug("Udate Driver details Started. ");
		List<ResponseDTO> responseList = new ArrayList<ResponseDTO>();
		ResponseEntity<List<ResponseDTO>> response = null;
		if (id <= 50000 && id >= 1) {
			if (driverRequestDTO.getLatitude() < -90 || driverRequestDTO.getLatitude() > 90
					|| driverRequestDTO.getLongitude() < -90 || driverRequestDTO.getLongitude() > 90) {
				// Setting up unProccessable Entity response
				FailureResponseDTO responseDTO = new FailureResponseDTO(
						"Invalid Location. Co-ordinates should be between +/- 90.");
				responseList.add(responseDTO);
				response = new ResponseEntity<List<ResponseDTO>>(responseList, HttpStatus.UNPROCESSABLE_ENTITY);
				logger.error("Invalid Location. Co-ordinates should be between +/- 90.");
			} else {
				driverRequestDTO.setUserId(id);
				driverService.updateDriverLocation(driverRequestDTO);
				response = new ResponseEntity<List<ResponseDTO>>(responseList, HttpStatus.OK);
			}
		} else {
			FailureResponseDTO responseDTO = new FailureResponseDTO(
					"Invalid Id, Valid Ids should be between 1 to 50000.");
			responseList.add(responseDTO);
			response = new ResponseEntity<List<ResponseDTO>>(responseList, HttpStatus.NOT_FOUND);
			logger.error("Invalid Id, Valid Ids should be between 1 to 50000.");
		}
		return response;
	}

	/*
	 * Rest controller to get the near by drivers list
	 */
	@RequestMapping(path = "/drivers", method = RequestMethod.POST)
	public ResponseEntity<List<ResponseDTO>> findDrivers(@RequestBody UserRequestDTO userRequestDTO) {
		logger.debug("Find the driver started");
		List<ResponseDTO> responseList = new ArrayList<ResponseDTO>();
		ResponseEntity<List<ResponseDTO>> response = null;

		if (!ObjectUtils.isEmpty(userRequestDTO.getLattitude())
				&& !ObjectUtils.isEmpty(userRequestDTO.getLongitude())) {
			if (userRequestDTO.getLattitude() < -90 || userRequestDTO.getLattitude() > 90
					|| userRequestDTO.getLongitude() < -90 || userRequestDTO.getLongitude() > 90) {
				// Setting up unProccessable Entity response
				FailureResponseDTO responseDTO = new FailureResponseDTO(
						"Invalid Location. Co-ordinates should be between +/- 90");
				responseList.add(responseDTO);
				response = new ResponseEntity<List<ResponseDTO>>(responseList, HttpStatus.UNPROCESSABLE_ENTITY);
				logger.error("Invalid Location. Co-ordinates should be between +/- 90.");
			} else {
				responseList = userService.findDrivers(userRequestDTO);
				response = new ResponseEntity<List<ResponseDTO>>(responseList, HttpStatus.OK);
				logger.debug("Driver details fetched successfully. ");
			}
		} else {
			FailureResponseDTO responseDTO = new FailureResponseDTO("Longitude and Latitude must be available");
			responseList.add(responseDTO);
			response = new ResponseEntity<List<ResponseDTO>>(responseList, HttpStatus.UNPROCESSABLE_ENTITY);
			logger.error("User Location is null");
		}
		return response;
	}
}
