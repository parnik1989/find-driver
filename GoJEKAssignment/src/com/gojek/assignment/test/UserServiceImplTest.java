package com.gojek.assignment.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.gojek.assignment.model.DriverResponseDTO;
import com.gojek.assignment.model.UserRequestDTO;
import com.gojek.assignment.repository.DriverRepository;
import com.gojek.assignment.service.impl.UserServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {
	
	@InjectMocks
	UserServiceImpl userService;
	
	@Mock
	DriverRepository driverRepository;
	
	UserRequestDTO userRequestDTO;
	DriverResponseDTO driverResponseDTO;
	List<DriverResponseDTO> driverList;
	
	@Before
	public void initializeTest(){
		userRequestDTO= new UserRequestDTO();
		userRequestDTO.setLattitude(22.45);
		userRequestDTO.setLongitude(23.45);
		userRequestDTO.setLimit(10L);
		userRequestDTO.setRadius(1.5);
		

		driverList= new ArrayList<DriverResponseDTO>();
		driverResponseDTO= new DriverResponseDTO();
		driverResponseDTO.setDistance(123.0);
		driverResponseDTO.setId(1L);
		driverResponseDTO.setLatitude(23.5);
		driverResponseDTO.setLongitude(25.4);
		driverList.add(driverResponseDTO);
		
	}
	
	@Test
	public void findDriversTest(){
		Mockito.when(driverRepository.getDriversList(Matchers.any(UserRequestDTO.class))).thenReturn(driverList);
		userService.findDrivers(userRequestDTO);
	}
	@Test
	public void findDriversTestWithoutRange(){
		userRequestDTO.setRadius(null);
		Mockito.when(driverRepository.getDriversList(Matchers.any(UserRequestDTO.class))).thenReturn(driverList);
		userService.findDrivers(userRequestDTO);
	}
	@Test
	public void findDriversTestWithoutLimit(){
		userRequestDTO.setLimit(null);
		Mockito.when(driverRepository.getDriversList(Matchers.any(UserRequestDTO.class))).thenReturn(driverList);
		userService.findDrivers(userRequestDTO);
		
	}

}
