package com.quinnox.bookMyDoctor1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quinnox.bookMyDoctor1.entities.Admin;
import com.quinnox.bookMyDoctor1.entities.Patient;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer>{
	
	public Admin findByUsernameAndPassword(String username, String password);

}
