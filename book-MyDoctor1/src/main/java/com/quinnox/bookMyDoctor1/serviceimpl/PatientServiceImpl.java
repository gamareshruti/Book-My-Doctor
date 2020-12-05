package com.quinnox.bookMyDoctor1.serviceimpl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.quinnox.bookMyDoctor1.beans.ResponseData;
import com.quinnox.bookMyDoctor1.entities.Doctor;
import com.quinnox.bookMyDoctor1.entities.Patient;
import com.quinnox.bookMyDoctor1.repository.PatientRepo;
import com.quinnox.bookMyDoctor1.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService{
	
	private static final String SUCCESS = "Success";
	private static final String FAILURE = "Failure";

	@Autowired
	PatientRepo patientrepo;

	@Override
	public ResponseData getAllPatient() throws Exception {
		ResponseData response = new ResponseData();
		List<Patient> patientdetails = this.patientrepo.findAll();
		
		if (patientdetails != null) {
			   response.setStatusCode(201);
			   response.setMessage(SUCCESS);
			   response.setDescription("Data found in DB");
			   response.setPatients(patientdetails);
			} else {
				response.setStatusCode(401);
				response.setMessage(FAILURE);
				response.setDescription("Data not found in DB");
			}
		return response;
	}

	@Override
	public ResponseData addPatient(Patient patient) throws Exception {
		/*Patient	patient1 = this.patientrepo.save(patient);
		return patient1;*/
		ResponseData response = new ResponseData();
		patient = this.patientrepo.save(patient);
		if (patient != null) {
			   response.setStatusCode(201);
			   response.setMessage(SUCCESS);
			   response.setDescription("Patient added successfully");
			   response.setPatients(Arrays.asList(patient));
			} else {
				response.setStatusCode(401);
				response.setMessage(FAILURE);
				response.setDescription("Data not added in DB");
			}
		return response;
	}

	@Override
	public ResponseData findByPatientId(int id) throws Exception {
		ResponseData response = new ResponseData();
		Patient patient = this.patientrepo.findById(id).orElse(null);
		
		 if (patient != null) {
			   response.setStatusCode(201);
			   response.setMessage(SUCCESS);
			   response.setDescription("Data found in DB");
			   response.setPatients(Arrays.asList(patient));
			} else {
				response.setStatusCode(401);
				response.setMessage(FAILURE);
				response.setDescription("Data not found in DB");
			}
		return response;
	}

	
	@Override
	public Patient fetchPatientByEmail(String email) throws Exception {
		Patient patient = this.patientrepo.findByEmail(email);
		return patient;
	}

	@Override
	public ResponseData fetchPatientByUsernameAndPassword(String username, String password)throws Exception {
		ResponseData response = new ResponseData();
		Patient patient = this.patientrepo.findByUsernameAndPassword(username, password);
		
		 if (patient != null) {
			   response.setStatusCode(201);
			   response.setMessage(SUCCESS);
			   response.setDescription("Login successful");
			   response.setPatients(Arrays.asList(patient));
			} else {
				response.setStatusCode(401);
				response.setMessage(FAILURE);
				response.setDescription("Bad data");
			}
		return response;
		
	}

	@Override
	public ResponseData updatePatient(@RequestBody Patient patient) throws Exception {
		ResponseData response = new ResponseData();
		int id = patient.getPatientId();
		Patient patientObj = this.patientrepo.findById(id).orElse(null);
		patientObj.setName(patient.getName());
		patientObj.setAge(patient.getAge());
		patientObj.setDateOfBirth(patient.getDateOfBirth());
		patientObj.setGender(patient.getGender());
		patientObj.setEmail(patient.getEmail());
		patientObj.setMobileNO(patient.getMobileNO());
		patientObj = this.patientrepo.save(patientObj);
	    if (patientObj != null) {
			   response.setStatusCode(201);
			   response.setMessage(SUCCESS);
			   response.setDescription("Patient updated successfully");
			   response.setPatients(Arrays.asList(patientObj));
			} else {
				response.setStatusCode(401);
				response.setMessage(FAILURE);
				response.setDescription("Not updated");
			}
		return response;
		
	}

	@Override
	public ResponseData deletePatient(int patientId) throws Exception {
		ResponseData response = new ResponseData();
		Patient patient =  patientrepo.deleteByPatientId(patientId);
		if (patient != null) {
			   response.setStatusCode(201);
			   response.setMessage(SUCCESS);
			   response.setDescription("Doctor deleted successfully");
			   response.setPatients(Arrays.asList(patient));
			} else {
				response.setStatusCode(401);
				response.setMessage(FAILURE);
				response.setDescription("Not updated");
			}
		return response;
	}

//	@Override
//	public ResponseData deletePatient(int patientId) throws Exception {
//		ResponseData response = new ResponseData();
//		Patient patient;
//		int id = patient.getPatientId();
//		patient = this.patientrepo.deleteById(id);
//		if (patient != null) {
//			   response.setStatusCode(201);
//			   response.setMessage(SUCCESS);
//			   response.setDescription("Patient added successfully");
//			   response.setPatients(Arrays.asList(patient));
//			} else {
//				response.setStatusCode(401);
//				response.setMessage(FAILURE);
//				response.setDescription("Data not added in DB");
//			}
//		return response;
//	}

	
	

	}


