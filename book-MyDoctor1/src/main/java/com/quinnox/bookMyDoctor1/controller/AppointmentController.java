package com.quinnox.bookMyDoctor1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.quinnox.bookMyDoctor1.beans.AppointmentTemp;
import com.quinnox.bookMyDoctor1.beans.ResponseData;
import com.quinnox.bookMyDoctor1.entities.Appointment;
import com.quinnox.bookMyDoctor1.service.AppointmentService;

@RestController
@CrossOrigin(origins="http://localhost:4200")  
@RequestMapping("/appointment")
public class AppointmentController {
	
	
	
	@Autowired
	AppointmentService appointmentservice;
	
	@RequestMapping(value = "/saveAppointmentdetails", method = RequestMethod.POST)
	public ResponseData saveAppointmentdetails(@RequestBody AppointmentTemp appointmentTemp)throws Exception{
		   ResponseData response = new ResponseData();
		   response = appointmentservice.saveAppointment(appointmentTemp);
		  
			return response;
	   }
	
	@RequestMapping(value = "/getAllAppointment", method = RequestMethod.GET)
	 public ResponseData getAllAppointment()throws Exception{
		   ResponseData response = new ResponseData();
		   response = appointmentservice.getAllAppointment();
		   
			return response;
	   }
	 
	 @RequestMapping(value = "/searchAppointmentByDocId/{doctorId}", method = RequestMethod.GET)
	 public ResponseData searchAppointmentByDocId(@PathVariable int doctorId)throws Exception{
		   ResponseData response = new ResponseData();
		   response = appointmentservice.searchAppointmentByDocId(doctorId);
		  
			return response;
	   }
	 
	 @RequestMapping(value = "/searchAppointmentByPatientId/{patientId}", method = RequestMethod.GET)
	 public ResponseData searchAppointmentByPatientId(@PathVariable int patientId)throws Exception{
		   ResponseData response = new ResponseData();
		   response = appointmentservice.searchAppointmentByPatientId(patientId);
		   
			return response;
	   }
	 
	 @RequestMapping(value = "/approveAppoByAppoId/{appointmentId}", method = RequestMethod.GET)
	 public ResponseData approveAppoByAppoId(@PathVariable int appointmentId)throws Exception{
		   ResponseData response = new ResponseData();
		   response = appointmentservice.approveAppoByAppoId(appointmentId);
		   
			return response;
	   }
	 
	 @RequestMapping(value = "/cancelAppoByAppoId/{appointmentId}", method = RequestMethod.GET)
	 public ResponseData cancelAppoByAppoId(@PathVariable int appointmentId)throws Exception{
		   ResponseData response = new ResponseData();
		   response = appointmentservice.cancelAppoByAppoId(appointmentId);
		   
			return response;
	   }
	 
	 @RequestMapping(value = "/updateAppointment", method = RequestMethod.POST)
	 public ResponseData updateAppointment(@RequestBody Appointment appointment)throws Exception{
		 ResponseData response = new ResponseData();
		 response = appointmentservice.updateAppointment(appointment);
		 return response;
	 }

//	@RequestMapping(value = "/getAllAppointment", method = RequestMethod.GET)
//	public List<Appointment> getAllAppointment() throws Exception {
//
//		return this.appointmentservice.getAllAppointment();
//	}
//
//	@RequestMapping(value = "/cancelAppoByAppoId", method = RequestMethod.POST)
//	public Appointment cancelAppoByAppoId(@RequestBody int appoId) throws Exception {
//
//		return this.appointmentservice.cancelAppoByAppoId(appoId);
//	}
//
//	@RequestMapping(value = "/approveAppoByAppoId", method = RequestMethod.POST)
//	public Appointment approveAppoByAppoId(@RequestBody int appoId) throws Exception {
//
//		return this.appointmentservice.approveAppoByAppoId(appoId);
//	}
//
//	@RequestMapping(value = "/saveAppointmentdetails", method = RequestMethod.POST)
//	public Appointment saveAppointmentdetails(@RequestBody Appointment appointment) throws Exception {
//
//		return this.appointmentservice.saveAppointment(appointment);
//
//	}
//
//	@RequestMapping(value = "/searchAppointmentByDocId", method = RequestMethod.POST)
//	public List<Appointment> searchAppointmentByDocId(@RequestBody int DocId) throws Exception {
//
//		return this.appointmentservice.searchAppointmentByDocId(DocId);
//	}
//
//	@RequestMapping(value = "/searchAppointmentByPatientId", method = RequestMethod.POST)
//	public List<Appointment> searchAppointmentByPatientId(@RequestBody int PatientId) throws Exception {
//
//		return this.appointmentservice.searchAppointmentByPatientId(PatientId);
//	}




}
