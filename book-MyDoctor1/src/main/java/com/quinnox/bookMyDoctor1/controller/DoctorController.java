package com.quinnox.bookMyDoctor1.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.quinnox.bookMyDoctor1.beans.ResponseData;
import com.quinnox.bookMyDoctor1.entities.Doctor;
import com.quinnox.bookMyDoctor1.entities.Patient;
import com.quinnox.bookMyDoctor1.service.DoctorService;
import com.quinnox.bookMyDoctor1.service.PatientService;

@RestController
@CrossOrigin(origins="http://localhost:4200")  
@RequestMapping("/doctor")
public class DoctorController {
	
	
	
	@Autowired
	DoctorService docservice;

	@Autowired
	PatientService patientservice;

	@RequestMapping("/")
	public String welcome(){
		return "welcom shruti";
	}
	
	@RequestMapping(value = "/saveDoctordetails", method = RequestMethod.POST)
	public ResponseData saveDoctordetails(@RequestBody Doctor doctor)throws Exception{
		   ResponseData response = new ResponseData();
		   String tempEmailId = doctor.getEmail();
		   if(tempEmailId != null && !" ".equals(tempEmailId)) {
			   Doctor doctorObj = null;
			   doctorObj = docservice.fetchDoctorByEmail(tempEmailId);
			   if(doctorObj != null) {
				   throw new Exception ("Doctor with " +tempEmailId+ " is already present");
			   }
		   }
		   response = docservice.saveDoctordetails(doctor);
		   
			return response;
	   }
	
	@RequestMapping(value = "/loginDoctor", method = RequestMethod.POST,  produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseData loginDoctor(@RequestBody Doctor doctor)throws Exception {
		ResponseData response = new ResponseData();
		String tempUsername = doctor.getUsername(); 
		String tempPassword = doctor.getPassword();
		if(tempUsername != null && tempPassword != null) {
			response = docservice.fetchDoctorByUsernameAndPassword(tempUsername, tempPassword);
		}
		return response;
	}
	
	   @RequestMapping(value = "/getAllDoctor", method = RequestMethod.GET)
	    public ResponseData getAllDoctor()throws Exception{
		   ResponseData response = new ResponseData();
		   response = docservice.getAllDoctor();
		   
			return response;
	   }
	   
	   @RequestMapping(value = "/findDoctortId/{doctorId}", method = RequestMethod.GET)
	   public ResponseData searchDoctor(@PathVariable int doctorId)throws Exception{
		   ResponseData response = new ResponseData();
		   response = docservice.findDoctortId(doctorId);
		   
			return response;
	   }
	   
	   @RequestMapping(value = "/findBySpeciality/{speciality}", method = RequestMethod.GET)
	   public ResponseData findBySpeciality(@PathVariable String speciality)throws Exception{
		   ResponseData response = new ResponseData();
		   response = docservice.findBySpeciality(speciality);
		   
			return response;
	   }
	   
	   
	   @RequestMapping(value = "/updateDoctor", method = RequestMethod.POST)
		 public ResponseData updateDoctor(@RequestBody Doctor doctor)throws Exception{
			 ResponseData response = new ResponseData();
			 response = docservice.updateDoctor(doctor);
			 return response;
		 }
	   
	   @RequestMapping(value = "/deleteDoctor/{doctorId}", method = RequestMethod.DELETE)
		  public ResponseData deleteDoctor(@PathVariable int doctorId)throws Exception{
			   ResponseData response = new ResponseData();
			   response = docservice.deleteDoctor(doctorId);
			  
				return response;
		   } 


//	@RequestMapping(value = "/getAllDoctor", method = RequestMethod.GET)
//	public List<Doctor> getAllDoctor() throws Exception {
//		return this.docservice.getAllDoctor();
//	}
//
//	@RequestMapping(value = "/saveDoctordetails", method = RequestMethod.POST)
//	public Doctor saveDoctordetails(@RequestBody Doctor doctor) throws Exception {
//		return this.docservice.saveDoctordetails(doctor);
//	}
//
//	@RequestMapping(value = "/findDoctortId/{doctorId}", method = RequestMethod.POST)
//	public Doctor searchDoctor(@PathVariable int doctorId) throws Exception {
//		return this.docservice.findDoctortId(doctorId);
//	}


}
