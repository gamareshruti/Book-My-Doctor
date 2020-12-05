package com.quinnox.bookMyDoctor1.service;

import java.util.List;

import com.quinnox.bookMyDoctor1.beans.ResponseData;
import com.quinnox.bookMyDoctor1.entities.Patient;

public interface PatientService {
	
	public ResponseData getAllPatient() throws Exception;
	
//	 public String savePatientdetails(String dashboardRequest)throws Exception;
	
	public ResponseData addPatient(Patient patient)throws Exception;
	 
	 public ResponseData findByPatientId(int patientId)throws Exception;
	 
     public Patient fetchPatientByEmail(String email)throws Exception;
     
     public ResponseData fetchPatientByUsernameAndPassword(String username, String password )throws Exception;
     
     public ResponseData updatePatient(Patient patient)throws Exception;
     
     public ResponseData deletePatient(int patientId)throws Exception;
	 


}
