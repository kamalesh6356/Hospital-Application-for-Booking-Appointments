package tech.stl.appointments.service;

import java.util.List;

import tech.stl.appointments.entity.Appointment;
import tech.stl.appointments.entity.AppointmentDetails;
import tech.stl.appointments.entity.ResponseTemplate;
import tech.stl.appointments.exception.AppointmentNotFoundException;

public interface AppointmentService {
	Appointment saveAppointments(Appointment appointment);
	List<Appointment> getAllAppointments();
public void deleteAppointments(long appointmentId);
public Appointment updateAppointments(Appointment appointment, long appointmentId);
public Appointment getAppointmentById(long appointmentId) throws AppointmentNotFoundException;
public AppointmentDetails getById(long id);



}

