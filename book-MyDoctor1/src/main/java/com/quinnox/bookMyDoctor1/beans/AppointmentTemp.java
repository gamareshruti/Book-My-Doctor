package com.quinnox.bookMyDoctor1.beans;


import javax.persistence.Column;

//import java.time.LocalDateTime;
//
//import org.springframework.format.annotation.DateTimeFormat;
//
//import org.springframework.format.annotation.DateTimeFormat.ISO;
//
//import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
@Data
public class AppointmentTemp {
	private int appointmentId;
	
//	@DateTimeFormat(iso = ISO.DATE_TIME)
//	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
//	private LocalDateTime appointmentTime;
	
	@Column(name = "appointmentDate")
	private String appointmentDate;
	
	@Column(name = "appointmentTime")
	private String appointmentTime;
	
	private String appointmentDetails;
	
	private int doctorId;
	
	private int patientId;
	
	private String status = "pending";

}
