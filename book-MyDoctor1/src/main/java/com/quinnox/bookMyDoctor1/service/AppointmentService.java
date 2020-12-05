package com.quinnox.bookMyDoctor1.service;

import com.quinnox.bookMyDoctor1.beans.AppointmentTemp;
import com.quinnox.bookMyDoctor1.beans.ResponseData;
import com.quinnox.bookMyDoctor1.entities.Appointment;



public interface AppointmentService {
	
	public ResponseData getAllAppointment() throws Exception;
	
	 public ResponseData saveAppointment(AppointmentTemp appointmentTemp)throws Exception;

	public ResponseData searchAppointmentByPatientId(int PatientId)throws Exception;
	
	public ResponseData searchAppointmentByDocId(int DocId)throws Exception;
	
	public ResponseData cancelAppoByAppoId(int appoId)throws Exception;

	public ResponseData approveAppoByAppoId(int appoId)throws Exception;
	
	public ResponseData updateAppointment(Appointment appointment)throws Exception;
	
}
