package com.springbackend.springboot.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="patients")
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long patientId;
	
	
	@Column(name="doctor_id", unique=true, nullable=false, insertable=false, updatable=true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long doctorId;

	
	@Column(name="patient_name")
	private String patientName;
	
	@Column(name="patient_age")
	private int patientAge;
	
	@Column(name="visited_doctor")
	private String visitedDoctor;
	
	@Column(name="dateof_visit")
	private Date dateOfVisit;
	
	@Column(name="doctor_prescription")
	private String doctorPrescription;

	@OneToOne(
			mappedBy = "patients"
			)
	
	
	@ManyToOne(
		cascade = CascadeType.ALL
			)
	//@JoinTable(name="doctors", joinColumns= {@JoinColumn(name="doctor_id")})
	@JoinColumn(
			name="doctor_id",
		referencedColumnName= "doctor_id",insertable=false, updatable=false, nullable=true
		)
private Doctor doctor;
	
	//@ManyToOne
	//@JoinColumn(name="doctorId", insertable = true, updatable = true, nullable = true)
	//private Doctor doctor;
	

	
	public Patient() {
		
	}
	


	public Patient(String patientName, int patientAge, String visitedDoctor, Date dateOfVisit,
			String doctorPrescription) {
		super();
		this.patientName = patientName;
		this.patientAge = patientAge;
		this.visitedDoctor = visitedDoctor;
		this.dateOfVisit = dateOfVisit;
		this.doctorPrescription = doctorPrescription;
	}






	public long getPatientId() {
		return patientId;
	}

	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}
	
	

	public Long getDoctorId() {
		return doctorId;
	}



	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}



	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public int getPatientAge() {
		return patientAge;
	}

	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}

	public String getVisitedDoctor() {
		return visitedDoctor;
	}

	public void setVisitedDoctor(String visitedDoctor) {
		this.visitedDoctor = visitedDoctor;
	}

	public Date getDateOfVisit() {
		return dateOfVisit;
	}

	public void setDateOfVisit(Date dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}

	public String getDoctorPrescription() {
		return doctorPrescription;
	}

	public void setDoctorPrescription(String doctorPrescription) {
		this.doctorPrescription = doctorPrescription;
	}



	
	

	

}
