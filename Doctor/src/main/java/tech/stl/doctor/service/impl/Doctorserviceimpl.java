package tech.stl.doctor.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import tech.stl.doctor.entity.Appointment;
import tech.stl.doctor.entity.Doctor;
import tech.stl.doctor.entity.ResponseTemplate;
import tech.stl.doctor.exception.DoctorNameNotFoundException;
import tech.stl.doctor.exception.DoctorNotFoundException;
import tech.stl.doctor.repository.DoctorRepository;
import tech.stl.doctor.service.Doctorservice;

@Service
public class Doctorserviceimpl implements Doctorservice {
@Autowired
private DoctorRepository doctorrepo;
@Autowired
private RestTemplate restTemplate;

public Doctorserviceimpl(DoctorRepository doctorrepo) {
	super();
	this.doctorrepo = doctorrepo;
}

@Override
public Doctor saveDoctor(@Valid @RequestBody Doctor  doctor) {
	// TODO Auto-generated method stub
	return doctorrepo.save(doctor);
}

@Override
public List<Doctor> getAllDoctors() {
	// TODO Auto-generated method stub
	return doctorrepo.findAll();
	}

@Override
public void deleteDoctor(long doctorId) {
	// TODO Auto-generated method stub
	 doctorrepo.deleteById(doctorId);
	
}

@Override
public Doctor getDoctorById(long doctorId) throws DoctorNotFoundException {
	// TODO Auto-generated method stub
	Optional<Doctor> doctor= doctorrepo.findById(doctorId);
	if(doctor.isPresent())
	{
		return doctor.get();
		}
	else
	{
		throw new DoctorNotFoundException("Doctor not found with id :"+doctorId);
	}
	}

@Override
public Doctor updateDoctor(Doctor doctor, long doctorId) {
	// TODO Auto-generated method stub
	Doctor dt=doctorrepo.findById(doctorId).get();
	if(Objects.nonNull(doctor.getName()) && !"".equalsIgnoreCase(doctor.getName()))
	{
         dt.setName(doctor.getName());
	}
	if(Objects.nonNull(doctor.getSpecialisation()) && !"".equalsIgnoreCase(doctor.getSpecialisation()))
	{
         dt.setSpecialisation(doctor.getSpecialisation());
	}
	return doctorrepo.save(dt);
	}

@Override
public Doctor getDoctorByName(String name) throws DoctorNameNotFoundException {
	// TODO Auto-generated method stub
	Doctor doctor= doctorrepo.findByName(name);
	if(doctor!=null) {
		return doctor;
		}
	else
	{
		throw new DoctorNameNotFoundException("Doctor not found with name :"+name);
	}
}

public ResponseTemplate getAppointmentswithDoctor(long doctorId) {
	// TODO Auto-generated method stub
	ResponseTemplate rest=new ResponseTemplate();
	Doctor doctor=doctorrepo.findById(doctorId).get();
	Appointment appointment=restTemplate.getForObject("http://localhost:8080/appointments/getappointments/"+doctor.getAppointmentId(), Appointment.class);

	rest.setDoctor(doctor);
	rest.setAppointment(appointment);

	return rest;
}
}

