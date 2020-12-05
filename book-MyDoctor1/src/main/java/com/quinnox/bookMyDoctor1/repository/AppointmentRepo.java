package com.quinnox.bookMyDoctor1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quinnox.bookMyDoctor1.entities.Appointment;
import com.quinnox.bookMyDoctor1.entities.Doctor;
import com.quinnox.bookMyDoctor1.entities.Patient;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Integer>{

	List<Appointment> findByPatient(Patient patient);

	List<Appointment> findByDoctor(Doctor doctor);
	
	/*@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE Appointment c SET c.status =:pending WHERE c.appointmentId = :appointmentId", nativeQuery = true)
	Appointment cancelStatus(@Param("appointmentId") String appointmentId);

*/	

	

}
