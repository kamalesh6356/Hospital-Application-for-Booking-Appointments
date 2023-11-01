package tech.stl.doctor.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.stl.doctor.entity.Doctor;
import tech.stl.doctor.entity.ResponseTemplate;
import tech.stl.doctor.exception.DoctorNameNotFoundException;
import tech.stl.doctor.exception.DoctorNotFoundException;
import tech.stl.doctor.service.Doctorservice;
@RestController
@RequestMapping("/doctors")
@CrossOrigin(origins="http://localhost:3000")

public class DoctorController {
     @Autowired
	private Doctorservice doctorservice;
     
     public DoctorController(Doctorservice doctorservice) {
		super();
		this.doctorservice = doctorservice;
	}
	@PostMapping
	public Doctor saveDoc(@Valid @RequestBody Doctor doctor)
	{
		return doctorservice.saveDoctor(doctor);
		
	}
     @GetMapping("/getdoctors")
     public List<Doctor> getDoctor()
     {
    	return doctorservice.getAllDoctors() ;
     }
     @DeleteMapping("/deletedoctor/{doctorId}")
     public String deleteDoctor(@PathVariable("doctorId") long doctorId)
     {
    	 doctorservice.deleteDoctor(doctorId);
    	 return "deleted";
    	 
     }
     @GetMapping("/getdoctors/{doctorId}")
     public Doctor getDoctorById(@PathVariable("doctorId") long doctorId) throws DoctorNotFoundException {
    	 
    	 return doctorservice.getDoctorById(doctorId);
     }
     @GetMapping("/name/{name}")
     public Doctor getDoctorByName(@PathVariable("name") String name) throws DoctorNameNotFoundException
     {
    	 return doctorservice.getDoctorByName(name);
     }
     @PutMapping("/updatedoctors/{doctorId}")
     public Doctor updateDoctor(@RequestBody Doctor doctor, @PathVariable long doctorId) 
     {
    	 return doctorservice.updateDoctor(doctor, doctorId);
     }
     @GetMapping("/appointments/{doctorId}")
     public ResponseTemplate getAppointmentswithDoctor(@PathVariable("doctorId") long doctorId) {
    	 return  doctorservice.getAppointmentswithDoctor(doctorId);
     }

}
