package com.quinnox.bookMyDoctor1.entities;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
//import java.time.LocalDateTime;
//
//import org.springframework.format.annotation.DateTimeFormat;
//
//import org.springframework.format.annotation.DateTimeFormat.ISO;
//
//import com.fasterxml.jackson.annotation.JsonFormat;


import lombok.Data;

@Entity
@Data
public class Appointment {
	@Id 
	@GeneratedValue 
	private int appointmentId;

//	@Column(name = "appointmentDate")
//	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
//	private String appointmentDate;
//	
//	@Column(name = "appointmentTime")
//	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="HH:mm")
//	private String appointmentTime;
//	
//	
//	@Column(name = "appointmentTime")
//	@DateTimeFormat(iso = ISO.DATE_TIME)
//	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
//	private LocalDateTime appointmentTime;
	
	@Column(name = "appointmentDate")
	private String appointmentDate;
	
	@Column(name = "appointmentTime")
	private String appointmentTime;

	@Column(name = "appointmentDetails")
	private String appointmentDetails;
    
	@OneToOne(cascade =CascadeType.MERGE)
	@JoinColumn(name="doctorId")
	private Doctor doctor;

	@OneToOne(cascade =CascadeType.MERGE)
	@JoinColumn(name="patientId")
	private Patient patient;
	
	@Column(name = "status")
	private String status = "pending";

	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

//	public String getAppointmentDate() {
//		return appointmentDate;
//	}
//
//	public void setAppointmentDate(String appointmentDate) {
//		this.appointmentDate = appointmentDate;
//	}

	public String getAppointmentDetails() {
		return appointmentDetails;
	}

	public void setAppointmentDetails(String appointmentDetails) {
		this.appointmentDetails = appointmentDetails;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	




}
