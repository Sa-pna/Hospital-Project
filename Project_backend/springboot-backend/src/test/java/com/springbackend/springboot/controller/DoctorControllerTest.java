package com.springbackend.springboot.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.springbackend.springboot.model.Doctor;
import com.springbackend.springboot.repository.DoctorRepository;
import com.springbackend.springboot.service.DoctorPatientService;

class DoctorControllerTest {
	
	@Autowired
	private DoctorPatientService doctorpatientService;
	
	@MockBean
	private DoctorRepository doctorRepository;
	@Test
	public void getUserTest() {
		
		//when(doctorRepository.findAll()).thenReturn(Stream.of(new Doctor("sapna", 33, "female", "aa"), 
		//new Doctor("sapnaaa", 33, "female", "uuu")).collect(Collectors.toList()));
	//assertEquals(2, doctorpatientService.getAllEmployees1().size());
		
	}
	
}
