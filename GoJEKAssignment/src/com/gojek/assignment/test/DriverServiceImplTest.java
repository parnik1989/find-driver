package com.gojek.assignment.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.gojek.assignment.model.Driver;
import com.gojek.assignment.model.DriverRequestDTO;
import com.gojek.assignment.repository.DriverRepository;
import com.gojek.assignment.service.impl.DriverServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class DriverServiceImplTest {
	
	@InjectMocks
	DriverServiceImpl driverService;
	
	@Mock
	DriverRepository driverRepository;
	
	DriverRequestDTO driverRequestDTO;
	
	@Before
	public void initializeTest(){
		driverRequestDTO= new DriverRequestDTO();
		driverRequestDTO.setLatitude(22.45);
		driverRequestDTO.setLongitude(23.45);
		driverRequestDTO.setAccuracy(2.5);
		driverRequestDTO.setUserId(1L);
		
	}
	
	@Test
	public void findDriversTest(){
		Mockito.doNothing().when(driverRepository).updateDriversLocation(Matchers.any(Driver.class));
		driverService.updateDriverLocation(driverRequestDTO);
	}


}
