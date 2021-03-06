package com.springbackend.springboot.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="doctors")
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="doctor_id")
	private Long doctorId;
	
	@Column(name="doctor_name")
	private String doctorName;
	
	@Column(name="doctor_age")
	private int doctorAge;
	
	@Column(name="doctor_gender")
	private String doctorGender;
	
	@Column(name="doctor_specilistfield")
	private String doctorSpecilistfield;

	//@OneToMany(mappedBy = "doctors")
	//private Set<Patient> patient;
	
	@OneToMany(
	cascade = CascadeType.ALL
	)
	@JoinColumn(
			name="doctor_id",
		referencedColumnName = "doctor_id", insertable=true, updatable=false, nullable=true
		
	)
	//@Fetch(value=FetchMode.SUBSELECT)
	
	private List<Patient> patient = new ArrayList<>();
	
	//@Fetch(value =  FetchMode.SELECT)
	//@OneToMany(cascade = CascadeType.ALL)
	//@JoinColumn(name="doctorId")
	//@JsonIgnore
	//private List<Patient> patientList;
	
	public Doctor() {
		
	}
	

	public Doctor(String doctorName, int doctorAge, String doctorGender, String doctorSpecilistfield) {
		super();
		this.doctorName = doctorName;
		this.doctorAge = doctorAge;
		this.doctorGender = doctorGender;
		this.doctorSpecilistfield = doctorSpecilistfield;
	}



	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public int getDoctorAge() {
		return doctorAge;
	}

	public void setDoctorAge(int doctorAge) {
		this.doctorAge = doctorAge;
	}

	public String getDoctorGender() {
		return doctorGender;
	}

	public void setDoctorGender(String doctorGender) {
		this.doctorGender = doctorGender;
	}

	public String getDoctorSpecilistfield() {
		return doctorSpecilistfield;
	}

	public void setDoctorSpecilistfield(String doctorSpecilistfield) {
		this.doctorSpecilistfield = doctorSpecilistfield;
	}

	
	

}
