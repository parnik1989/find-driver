package com.gojek.assignment.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.gojek.assignment.model.ResponseDTO;
import com.gojek.assignment.model.UserRequestDTO;

/**
 * @author parnik User details and search related service layer Interface
 *
 */
public interface UserService {

	public List<ResponseDTO> findDrivers(UserRequestDTO userRequestDTO) throws DataAccessException;
}
