//package com.quinnox.bookMyDoctor1.entities;
//
//import java.util.Date;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//
//import com.fasterxml.jackson.annotation.JsonFormat;
//
//import lombok.Data;
//
//@Entity
//@Data
//public class User {
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name = "userId")
//	private int userId;
//	
//	@Column(name = "userName")
//	private String userName;
//	
//	@Column(name = "age")
//	private int age;
//	
//	@Column(name = "gender")
//	private String gender;
//	
//	@Column(name = "location")
//	private String location;
//	
//	@Column(name = "mobileNO")
//	private String mobileNO;
//	
//	@Column(name = "dieseaseDetails")
//	private String dieseaseDetails;
//	
//	@Column(name = "dateOfBirth")
//	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
//	private Date dateOfBirth;
//	
//	@Column(name = "qualification")
//	private String qualification;
//	
//	@Column(name = "speciality")
//	private String speciality;
//	
//	@Column(name = "email")
//	private String email;
//	
//}
