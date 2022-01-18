package com.springbackend.springboot.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbackend.springboot.model.Doctor;
import com.springbackend.springboot.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

	
	List<Patient> findByDoctor(Doctor doctor, Sort sort);
}
