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
import com.quinnox.bookMyDoctor1.entities.Patient;
import com.quinnox.bookMyDoctor1.service.DoctorService;
import com.quinnox.bookMyDoctor1.service.PatientService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")  
@RequestMapping("/patient")
public class PatientController {
	
	
	
	@Autowired
	PatientService patientservice;
	
	@Autowired
	DoctorService docservice;
	
	@RequestMapping(value = "/loginPatient", method = RequestMethod.POST,  produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseData loginPatient(@RequestBody Patient patient)throws Exception {
		ResponseData response = new ResponseData();
		String tempUsername = patient.getUsername();
		String tempPassword = patient.getPassword();
		if(tempUsername != null && tempPassword != null) {
			response = patientservice.fetchPatientByUsernameAndPassword(tempUsername, tempPassword);
		}
		return response;
	}
	
	@RequestMapping(value = "/addPatient", method = RequestMethod.POST,  produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseData addPatient(@RequestBody Patient patient)throws Exception{
		   ResponseData response = new ResponseData();
		   String tempEmailId = patient.getEmail();
		   if(tempEmailId != null && !" ".equals(tempEmailId)) {
			   Patient patientObj = null;
			   patientObj = patientservice.fetchPatientByEmail(tempEmailId);
			   if(patientObj != null) {
				   throw new Exception ("Patient with " +tempEmailId+ " is already present");
			   }
		   }
		   response = patientservice.addPatient(patient);
		   
			return response;
	   }
	

	   
	@RequestMapping(value = "/getAllPatient", method = RequestMethod.GET)
	   public ResponseData getAllPatient()throws Exception{
		   ResponseData response = new ResponseData();
		   response = patientservice.getAllPatient();
		   
			return response;
	   }
	
	 @RequestMapping(value = "/findByPatientId/{patientId}", method = RequestMethod.GET)
	  public ResponseData findByPatientId(@PathVariable int patientId)throws Exception{
		   ResponseData response = new ResponseData();
		   response = patientservice.findByPatientId(patientId);
		  
			return response;
	   }
	 
	 @RequestMapping(value = "/updatePatient", method = RequestMethod.POST)
	 public ResponseData updatePatient(@RequestBody Patient patient)throws Exception{
		 ResponseData response = new ResponseData();
		 response = patientservice.updatePatient(patient);
		 return response;
	 }
	 
	 @RequestMapping(value = "/deletePatient/{patientId}", method = RequestMethod.DELETE)
	  public ResponseData deletePatient(@PathVariable int patientId)throws Exception{
		   ResponseData response = new ResponseData();
		   response = patientservice.deletePatient(patientId);
		  
			return response;
	   } 
	    	    
	    

	   
	  
	    
	    
//	    @RequestMapping(value = "/addPatient", method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
//	    public Patient addPatient(@RequestBody Patient patient) throws Exception {
//	    	return this.patientservice.addPatient(patient);	
//	    }
	   
//		 @RequestMapping(value = "/getAllPatient", method = RequestMethod.GET)
//	    public List<Patient> getAllPatient() throws Exception {
//	       
//	        return this.patientservice.getAllPatient();
//	    }
	   
//	    @RequestMapping(value = "/findByPatientId/{patientId}", method = RequestMethod.GET)
//	    public Patient findByPatientId(@PathVariable int patientId) throws Exception {
//	    	return this.patientservice.findByPatientId(patientId);    
//	    }
	   

}
