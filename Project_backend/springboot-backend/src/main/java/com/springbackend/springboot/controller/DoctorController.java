package com.springbackend.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbackend.springboot.exception.ResourceNotFoundException;
import com.springbackend.springboot.model.Doctor;
import com.springbackend.springboot.model.Patient;
import com.springbackend.springboot.repository.DoctorRepository;
import com.springbackend.springboot.repository.PatientRepository;
import com.springbackend.springboot.service.DoctorPatientService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")

@Service
public class DoctorController implements DoctorPatientService {

	@Autowired
	private DoctorRepository doctorRepository;
	@Autowired
	private PatientRepository patientRepository;

	@GetMapping("/doctors")
	public List<Doctor> getAllDoctors() {
		return doctorRepository.findAll();
	}

	@PostMapping("/doctors")
	public Doctor createDoctor(@RequestBody Doctor doctor) {
		doctorRepository.save(doctor);
		return doctorRepository.save(doctor);
	}

	@GetMapping("/doctors/{id}")
	public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id) {
		Doctor doctor = doctorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Doctor not exist with id : " + id));
		return ResponseEntity.ok(doctor);
	}

	@DeleteMapping("/doctors/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteDoctors(@PathVariable Long id) {
		Doctor doctors = doctorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id : " + id));

		doctorRepository.delete(doctors);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);

	}

	@GetMapping("/patients")
	public List<Patient> getAllPatients() {

		return patientRepository.findAll();
	}

	@PostMapping("/patients")
	public Patient createPatients(@RequestBody Patient patient) {
		doctorRepository.save(patient);
		return patientRepository.save(patient);
	}

	@GetMapping("/patients/{id}")
	public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
		Patient patient = patientRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Doctor not exist with id : " + id));
		return ResponseEntity.ok(patient);
	}

	@DeleteMapping("/patients/{id}")
	public ResponseEntity<Map<String, Boolean>> deletePatient(@PathVariable Long id) {
		Patient patients = patientRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id : " + id));

		patientRepository.delete(patients);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);

	}

}
