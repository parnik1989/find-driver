package com.gojek.assignment.controller;

import java.util.ArrayList;
import java.util.List;

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

@RestController
public class CentralController {

	@Autowired
	DriverService driverService;
	@Autowired
	UserService userService;

	@RequestMapping(path = "/")
	public String welcome() {// Welcome page, non-rest
		return "Welcome to Find My Driver.";
	}

	@RequestMapping(path = "/drivers/{id}/location", method = RequestMethod.PUT)
	public ResponseEntity<List<ResponseDTO>> updateDriverLocation(@PathVariable Long id,
			@RequestBody DriverRequestDTO driverDTO) {
		List<ResponseDTO> responseList = new ArrayList<ResponseDTO>();
		ResponseEntity<List<ResponseDTO>> response = null;
		if (id <= 50000 && id >= 1) {
			if (driverDTO.getLattitude() < -90 || driverDTO.getLattitude() > 90 || driverDTO.getLongitude() < -90
					|| driverDTO.getLongitude() > 90) {
				// Setting up unProccessable Entity response
				FailureResponseDTO responseDTO = new FailureResponseDTO(
						"Invalid Location. Co-ordinates should be between +/- 90");
				responseList.add(responseDTO);
				response = new ResponseEntity<List<ResponseDTO>>(responseList, HttpStatus.UNPROCESSABLE_ENTITY);
			} else {
				driverDTO = new DriverRequestDTO();
				driverDTO.setUserId(id);
				driverService.saveDriverDetails(driverDTO);
				response = new ResponseEntity<List<ResponseDTO>>(responseList, HttpStatus.OK);
			}
		} else {
			FailureResponseDTO responseDTO = new FailureResponseDTO(
					"Invalid Id, Valid Ids should be between 1 to 50000");
			responseList.add(responseDTO);
			response = new ResponseEntity<List<ResponseDTO>>(responseList, HttpStatus.NOT_FOUND);
		}
		return response;
	}

	@RequestMapping(path = "/drivers", method = RequestMethod.POST)
	public ResponseEntity<List<ResponseDTO>> findDrivers(@RequestBody UserRequestDTO userRequestDTO) {
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
			} else {
				responseList = userService.findDrivers(userRequestDTO);
				response = new ResponseEntity<List<ResponseDTO>>(responseList, HttpStatus.OK);
			}
		}
		return response;
	}
}
