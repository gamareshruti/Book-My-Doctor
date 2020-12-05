package com.quinnox.bookMyDoctor1.serviceimpl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quinnox.bookMyDoctor1.beans.ResponseData;
import com.quinnox.bookMyDoctor1.entities.Doctor;
import com.quinnox.bookMyDoctor1.entities.Patient;
import com.quinnox.bookMyDoctor1.repository.AppointmentRepo;
import com.quinnox.bookMyDoctor1.repository.DoctorRepo;
import com.quinnox.bookMyDoctor1.repository.PatientRepo;
import com.quinnox.bookMyDoctor1.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService{
	
	private static final String SUCCESS = "Success";
	private static final String FAILURE = "Failure";
	
	@Autowired
	DoctorRepo doctorrepo;

	@Autowired
	PatientRepo patientrepo;

	@Autowired
	AppointmentRepo appointmentrepo;

	@Override
	public ResponseData getAllDoctor() throws Exception {
		ResponseData response = new ResponseData();
		List<Doctor> doctordetails = this.doctorrepo.findAll();
		
		if (doctordetails != null) {
			   response.setStatusCode(201);
			   response.setMessage(SUCCESS);
			   response.setDescription("Data found in DB");
			   response.setDoctors(doctordetails);
			} else {
				response.setStatusCode(401);
				response.setMessage(FAILURE);
				response.setDescription("Data not found in DB");
			}
		return response;

	}

	@Override
	public ResponseData findDoctortId(int id) throws Exception {
		ResponseData response = new ResponseData();
		Doctor doctor = doctorrepo.findById(id).orElse(null);
		if (doctor != null) {
			   response.setStatusCode(201);
			   response.setMessage(SUCCESS);
			   response.setDescription("Data found in DB");
			   response.setDoctors(Arrays.asList(doctor));
			} else {
				response.setStatusCode(401);
				response.setMessage(FAILURE);
				response.setDescription("Data not found in DB");
			}
		return response;

	}
	@Override
	public ResponseData saveDoctordetails(Doctor doctor) throws Exception {
		ResponseData response = new ResponseData();
		doctor = this.doctorrepo.save(doctor);
		
		if (doctor != null) {
			   response.setStatusCode(201);
			   response.setMessage(SUCCESS);
			   response.setDescription("Data found in DB");
			   response.setDoctors(Arrays.asList(doctor));
			} else {
				response.setStatusCode(401);
				response.setMessage(FAILURE);
				response.setDescription("Data not found in DB");
			}
		return response;

	}

	@Override
	public Doctor fetchDoctorByEmail(String email) throws Exception {
		
		Doctor doctor = this.doctorrepo.findByEmail(email);
		return doctor;
	}

	@Override
	public ResponseData fetchDoctorByUsernameAndPassword(String username, String password) throws Exception {
		ResponseData response = new ResponseData();
		Doctor doctor = this.doctorrepo.findByUsernameAndPassword(username, password);
		
		 if (doctor != null) {
			   response.setStatusCode(201);
			   response.setMessage(SUCCESS);
			   response.setDescription("Login successful");
			   response.setDoctors(Arrays.asList(doctor));
			} else {
				response.setStatusCode(401);
				response.setMessage(FAILURE);
				response.setDescription("Bad data");
			}
		return response;
	}

	@Override
	public ResponseData updateDoctor(Doctor doctor) throws Exception {
		ResponseData response = new ResponseData();
		int id = doctor.getDoctorId();
		Doctor doctorObj = this.doctorrepo.findById(id).orElse(null);
		doctorObj.setDoctorName(doctor.getDoctorName());
		doctorObj.setQualification(doctor.getQualification());
		doctorObj.setSpeciality(doctor.getSpeciality());
		doctorObj.setMobileNO(doctor.getMobileNO());
		doctorObj.setLocation(doctor.getLocation());
		doctorObj.setEmail(doctor.getEmail());
		doctorObj = this.doctorrepo.save(doctorObj);
	    if (doctorObj != null) {
			   response.setStatusCode(201);
			   response.setMessage(SUCCESS);
			   response.setDescription("Doctor updated successfully");
			   response.setDoctors(Arrays.asList(doctorObj));
			} else {
				response.setStatusCode(401);
				response.setMessage(FAILURE);
				response.setDescription("Not updated");
			}
		return response;
	}

	@Override
	public ResponseData deleteDoctor(int doctorId) throws Exception {
		ResponseData response = new ResponseData();
		Doctor doctor = null;
		int id = doctor.getDoctorId();
		Doctor docObject = doctorrepo.deleteByDoctorId(id);
		if (docObject != null) {
			   response.setStatusCode(201);
			   response.setMessage(SUCCESS);
			   response.setDescription("Doctor deleted successfully");
			   response.setDoctors(Arrays.asList(docObject));
			} else {
				response.setStatusCode(401);
				response.setMessage(FAILURE);
				response.setDescription("Not updated");
			}
		return response;

	}

	@Override
	public ResponseData findBySpeciality(String speciality) throws Exception {
		ResponseData response = new ResponseData();
		 List<Doctor> doctor = doctorrepo.findBySpeciality(speciality);
		if (doctor != null) {
			   response.setStatusCode(201);
			   response.setMessage(SUCCESS);
			   response.setDescription("Data found in DB");
			   response.setDoctors(doctor);
			} else {
				response.setStatusCode(401);
				response.setMessage(FAILURE);
				response.setDescription("Data not found in DB");
			}
		return response;
	}

}
