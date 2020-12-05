package com.quinnox.bookMyDoctor1.beans;

import java.util.List;

import com.quinnox.bookMyDoctor1.entities.Appointment;
import com.quinnox.bookMyDoctor1.entities.Doctor;
import com.quinnox.bookMyDoctor1.entities.Patient;

import lombok.Data;

@Data
public class ResponseData {
	
	private int statusCode;
	
	private String message;
	
	private String description;
	
	private List<Patient> patients;
	
	private List<Doctor> doctors;
	
	private List<Appointment> appointments;

}
