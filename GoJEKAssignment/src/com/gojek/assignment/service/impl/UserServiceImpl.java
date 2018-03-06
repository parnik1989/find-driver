package com.gojek.assignment.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.gojek.assignment.model.Driver;
import com.gojek.assignment.model.DriverResponseDTO;
import com.gojek.assignment.model.ResponseDTO;
import com.gojek.assignment.model.UserRequestDTO;
import com.gojek.assignment.repository.DriverRepository;
import com.gojek.assignment.service.UserService;

@Service(value="userService")
public class UserServiceImpl implements UserService {

	@Autowired
	DriverRepository driverRepository;
	
	@Override
	public List<ResponseDTO> findDrivers(UserRequestDTO userRequestDTO) {
		if(ObjectUtils.isEmpty(userRequestDTO.getRadius())){
			userRequestDTO.setRadius(0.5);
		}
		if(ObjectUtils.isEmpty(userRequestDTO.getLimit())){
			userRequestDTO.setLimit(10L);
		}
		
		List<Driver> availableDrivers=driverRepository.getDriversList(userRequestDTO);
		List<ResponseDTO> responseList= new ArrayList<ResponseDTO>();
		for(Driver dto: availableDrivers){
			DriverResponseDTO responseDTO= new DriverResponseDTO();
			responseDTO.setId(dto.getId());
			responseDTO.setLatitude(dto.getLattitude());
			responseDTO.setLongitude(dto.getLattitude());
			responseList.add(responseDTO);
		}
		return responseList;
	}

}
