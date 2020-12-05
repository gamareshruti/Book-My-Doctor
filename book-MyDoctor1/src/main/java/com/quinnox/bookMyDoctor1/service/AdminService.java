package com.quinnox.bookMyDoctor1.service;

import com.quinnox.bookMyDoctor1.beans.ResponseData;
import com.quinnox.bookMyDoctor1.entities.Admin;

public interface AdminService {
	
	public Admin fetchByUsernameAndPassword(String username, String password )throws Exception;
}
