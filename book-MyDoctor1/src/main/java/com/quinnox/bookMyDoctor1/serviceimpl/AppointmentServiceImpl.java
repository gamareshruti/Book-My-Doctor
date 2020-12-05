package com.quinnox.bookMyDoctor1.serviceimpl;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quinnox.bookMyDoctor1.beans.AppointmentTemp;
import com.quinnox.bookMyDoctor1.beans.ResponseData;
import com.quinnox.bookMyDoctor1.entities.Appointment;
import com.quinnox.bookMyDoctor1.entities.Doctor;
import com.quinnox.bookMyDoctor1.entities.Patient;
import com.quinnox.bookMyDoctor1.repository.AppointmentRepo;
import com.quinnox.bookMyDoctor1.repository.DoctorRepo;
import com.quinnox.bookMyDoctor1.repository.PatientRepo;
import com.quinnox.bookMyDoctor1.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService{

	private static final String SUCCESS = "Success";
	private static final String FAILURE = "Failure";

	@Autowired
	AppointmentRepo appointmentrepo;

	@Autowired
	DoctorRepo doctorrepo;

	@Autowired
	PatientRepo patientrepo;

	@Override
	public ResponseData getAllAppointment() throws Exception {
		ResponseData response = new ResponseData();
		List<Appointment> appointment = this.appointmentrepo.findAll();
		if (appointment != null) {
			   response.setStatusCode(201);
			   response.setMessage(SUCCESS);
			   response.setDescription("Data found in DB");
			   response.setAppointments(appointment);
			} else {
				response.setStatusCode(401);
				response.setMessage(FAILURE);
				response.setDescription("Data not found in DB");
			}
		return response;
	}
	@Override
	public ResponseData saveAppointment(AppointmentTemp appointmentTemp) throws Exception {
		ResponseData response = new ResponseData();
		Appointment appointment = new Appointment();
		appointment.setAppointmentDate(appointmentTemp.getAppointmentDate());
		appointment.setAppointmentTime(appointmentTemp.getAppointmentTime());
		appointment.setAppointmentDetails(appointmentTemp.getAppointmentDetails());
		int id = appointmentTemp.getPatientId();
		Patient patient = this.patientrepo.findById(id).orElse(null);
		appointment.setPatient(patient);
		 id = appointmentTemp.getDoctorId();
		 Doctor doctor = this.doctorrepo.findById(id).orElse(null);
		 appointment.setDoctor(doctor);
		appointment = this.appointmentrepo.save(appointment);
		 if (appointment != null) {
			   response.setStatusCode(201);
			   response.setMessage(SUCCESS);
			   response.setDescription("Data found in DB");
			   response.setAppointments(Arrays.asList(appointment));
			} else {
				response.setStatusCode(401);
				response.setMessage(FAILURE);
				response.setDescription("Data not found in DB");
			}
		return response;
	}
	@Override
	public ResponseData searchAppointmentByPatientId(int id) throws Exception {
		ResponseData response = new ResponseData();
		Optional<Patient> patient = this.patientrepo.findById(id);
		List<Appointment> appointment = this.appointmentrepo.findByPatient(patient.get());
		if (appointment != null) {
			   response.setStatusCode(201);
			   response.setMessage(SUCCESS);
			   response.setDescription("Data found in DB");
			   response.setAppointments(appointment);
			} else {
				response.setStatusCode(401);
				response.setMessage(FAILURE);
				response.setDescription("Data not found in DB");
			}
		return response;
	}
	@Override
	public ResponseData searchAppointmentByDocId(int id) throws Exception {
		ResponseData response = new ResponseData();
		Optional<Doctor> doctor = this.doctorrepo.findById(id);
		List<Appointment>  appointment = this.appointmentrepo.findByDoctor(doctor.get());
		 if (appointment != null) {
			   response.setStatusCode(201);
			   response.setMessage(SUCCESS);
			   response.setDescription("Data found in DB");
			   response.setAppointments(appointment);
			} else {
				response.setStatusCode(401);
				response.setMessage(FAILURE);
				response.setDescription("Data not found in DB");
			}
		return response;
	}

	@Override
	public ResponseData cancelAppoByAppoId(int id) throws Exception {
		ResponseData response = new ResponseData();
		Appointment	appointment = this.appointmentrepo.findById(id).orElse(null);
		appointment.setStatus("cancel");
		appointment = this.appointmentrepo.save(appointment);
		if (appointment != null) {
			   response.setStatusCode(201);
			   response.setMessage(SUCCESS);
			   response.setDescription("Data found in DB");
			   response.setAppointments(Arrays.asList(appointment));
			} else {
				response.setStatusCode(401);
				response.setMessage(FAILURE);
				response.setDescription("Data not found in DB");
			}
		return response;	
	}
	@Override
	public ResponseData approveAppoByAppoId(int id) throws Exception {
		ResponseData response = new ResponseData();
		Appointment	appointment = this.appointmentrepo.findById(id).orElse(null);
		appointment.setStatus("approve");
		appointment = this.appointmentrepo.save(appointment);
		if (appointment != null) {
			   response.setStatusCode(201);
			   response.setMessage(SUCCESS);
			   response.setDescription("Data found in DB");
			   response.setAppointments(Arrays.asList(appointment));
			} else {
				response.setStatusCode(401);
				response.setMessage(FAILURE);
				response.setDescription("Data not found in DB");
			}
		return response;		
	}
	@Override
	public ResponseData updateAppointment(Appointment appointment) throws Exception {
		ResponseData response = new ResponseData();
		int id = appointment.getAppointmentId();
		Appointment obj = this.appointmentrepo.findById(id).orElse(null);
//		obj.setAppointmentDate(appointment.getAppointmentDate());
		obj.setAppointmentDetails(appointment.getAppointmentDetails());
		obj.setDoctor(appointment.getDoctor());
		obj.setPatient(appointment.getPatient());
		obj = this.appointmentrepo.save(obj);
		 if (obj != null) {
			   response.setStatusCode(201);
			   response.setMessage(SUCCESS);
			   response.setDescription("Appointment updated successfully");
			   response.setAppointments(Arrays.asList(obj));
			} else {
				response.setStatusCode(401);
				response.setMessage(FAILURE);
				response.setDescription("Not updated");
			}
		return response;
	}



}


