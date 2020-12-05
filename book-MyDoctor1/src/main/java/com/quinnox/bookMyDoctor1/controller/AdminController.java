package com.quinnox.bookMyDoctor1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.quinnox.bookMyDoctor1.beans.ResponseData;
import com.quinnox.bookMyDoctor1.entities.Admin;
import com.quinnox.bookMyDoctor1.entities.Appointment;
import com.quinnox.bookMyDoctor1.entities.Patient;
import com.quinnox.bookMyDoctor1.service.AdminService;

@RestController
@CrossOrigin(origins="http://localhost:4200")  
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService service;

	@RequestMapping(value = "/loginAdmin", method = RequestMethod.POST,  produces = MediaType.APPLICATION_JSON_VALUE)
	public Admin loginAdmin(@RequestBody Admin admin)throws Exception {
		String tempUsername = admin.getUsername();
		String tempPassword = admin.getPassword();
		if(tempUsername != null && tempPassword != null) {
			admin = service.fetchByUsernameAndPassword(tempUsername, tempPassword);
		}
		return admin;
	}
}
