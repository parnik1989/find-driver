package com.gojek.assignment.service;

import java.util.List;

import com.gojek.assignment.model.ResponseDTO;
import com.gojek.assignment.model.UserRequestDTO;

public interface UserService {

	
	public List<ResponseDTO> findDrivers(UserRequestDTO userRequestDTO);
}
