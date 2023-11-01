package tech.stl.doctor.service;

import java.util.List;

import tech.stl.doctor.entity.Doctor;
import tech.stl.doctor.entity.ResponseTemplate;
import tech.stl.doctor.exception.DoctorNameNotFoundException;
import tech.stl.doctor.exception.DoctorNotFoundException;



public interface Doctorservice {
	Doctor saveDoctor(Doctor doctor);
    List<Doctor> getAllDoctors();
    void deleteDoctor(long doctorId);
    Doctor getDoctorById(long doctorId) throws DoctorNotFoundException;
	Doctor updateDoctor(Doctor doctor,long doctorId);
	Doctor getDoctorByName(String name) throws DoctorNameNotFoundException;
	public ResponseTemplate getAppointmentswithDoctor(long doctorId);

   

}
