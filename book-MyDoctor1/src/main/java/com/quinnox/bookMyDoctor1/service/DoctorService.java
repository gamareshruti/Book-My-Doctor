package com.quinnox.bookMyDoctor1.service;

import java.util.List;

import com.quinnox.bookMyDoctor1.beans.ResponseData;
import com.quinnox.bookMyDoctor1.entities.Doctor;
import com.quinnox.bookMyDoctor1.entities.Patient;

public interface DoctorService {

	public ResponseData getAllDoctor() throws Exception;

	public ResponseData saveDoctordetails(Doctor doctor)throws Exception;

	public ResponseData findDoctortId(int doctorId)throws Exception;
	
	public ResponseData findBySpeciality(String speciality)throws Exception;

	public Doctor fetchDoctorByEmail(String email)throws Exception;
    
    public ResponseData fetchDoctorByUsernameAndPassword(String username, String password )throws Exception;
    
    public ResponseData updateDoctor(Doctor doctor)throws Exception;
    
    public ResponseData deleteDoctor(int doctorId)throws Exception;
}
