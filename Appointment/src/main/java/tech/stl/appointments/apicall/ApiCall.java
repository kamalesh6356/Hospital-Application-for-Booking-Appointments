package tech.stl.appointments.apicall;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import tech.stl.appointments.entity.Doctor;
import tech.stl.appointments.entity.Patient;

@Service
public class ApiCall {
	@Autowired
	private RestTemplate restTemplate;
	
	private static final String patientMicroserviceBasedURL="http://localhost:8082";
	private static final String DoctorMicroserviceBasedURL="http://localhost:8081";
	
	public Patient getPatientDetails(long id)
	{
		Patient patient=restTemplate.getForObject(patientMicroserviceBasedURL+"/patients/getpatients/{id}", Patient.class,id);
		return patient;
		
	}
	public Doctor getDoctorDetails(long doctorId)
	{
		Doctor doctor=restTemplate.getForObject(DoctorMicroserviceBasedURL+"/doctors/getdoctors/{doctorId}", Doctor.class,doctorId);
		return doctor;
		
	}
	

}
