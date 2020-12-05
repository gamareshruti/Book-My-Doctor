package com.quinnox.bookMyDoctor1.serviceimpl;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quinnox.bookMyDoctor1.beans.ResponseData;
import com.quinnox.bookMyDoctor1.entities.Admin;
import com.quinnox.bookMyDoctor1.entities.Patient;
import com.quinnox.bookMyDoctor1.repository.AdminRepo;
import com.quinnox.bookMyDoctor1.service.AdminService;


@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	AdminRepo repo;

	@Override
	public Admin fetchByUsernameAndPassword(String username, String password) throws Exception {
		Admin admin = this.repo.findByUsernameAndPassword(username, password);
		return admin;
		
	}
	
	}
