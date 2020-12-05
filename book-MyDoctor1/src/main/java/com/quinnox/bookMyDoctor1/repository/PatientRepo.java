package com.quinnox.bookMyDoctor1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quinnox.bookMyDoctor1.beans.ResponseData;
import com.quinnox.bookMyDoctor1.entities.Patient;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Integer>{

	public Patient findByEmail(String email);
	
	public Patient findByUsernameAndPassword(String username, String password);
	
	public Patient deleteByPatientId(int patientId);
	
	


}
