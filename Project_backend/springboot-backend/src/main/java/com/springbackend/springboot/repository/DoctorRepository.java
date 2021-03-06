package com.springbackend.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbackend.springboot.model.Doctor;
import com.springbackend.springboot.model.Patient;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

	void save(Patient patient);

	Doctor findBydoctorId(int doctorId);

}
