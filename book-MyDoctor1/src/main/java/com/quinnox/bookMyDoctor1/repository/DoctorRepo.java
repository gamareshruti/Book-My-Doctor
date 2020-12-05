package com.quinnox.bookMyDoctor1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quinnox.bookMyDoctor1.entities.Doctor;
import com.quinnox.bookMyDoctor1.entities.Patient;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Integer>{
	
    public Doctor findByEmail(String email);
	
	public Doctor findByUsernameAndPassword(String username, String password);
	
	public List<Doctor> findBySpeciality(String speciality);
	
	public Doctor deleteByDoctorId(int doctorId);

}
