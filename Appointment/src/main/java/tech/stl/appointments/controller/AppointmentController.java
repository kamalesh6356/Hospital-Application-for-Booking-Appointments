package tech.stl.appointments.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tech.stl.appointments.entity.Appointment;
import tech.stl.appointments.entity.AppointmentDetails;
import tech.stl.appointments.entity.ResponseTemplate;
import tech.stl.appointments.exception.AppointmentNotFoundException;
import tech.stl.appointments.service.AppointmentService;
import tech.stl.appointments.service.impl.AppointmentServiceImpl;
@RestController
@RequestMapping("/appointments")
@CrossOrigin(origins="http://localhost:3000")
public class AppointmentController {
	@Autowired
	private AppointmentService appservice;
	@PostMapping
	public Appointment saveApppointments(@Valid @RequestBody Appointment appointment)
	{
		return appservice.saveAppointments(appointment);
	}
	@GetMapping("/getappointments")
	public List<Appointment> getAppointments()
	{
		return appservice.getAllAppointments();
		}
	
	@DeleteMapping("/deleteappointment/{appointmentId}")
	public String DeleteAppointments(@PathVariable("appointmentId") long appointmentId)
	{
		appservice.deleteAppointments(appointmentId);
		return "deleted";
	}
	@PutMapping("/updateappointment/{appointmentId}")
	public Appointment updateAppointment(@PathVariable("appointmentId") long appointmentId,@RequestBody Appointment appointment)
	{
		return appservice.updateAppointments(appointment, appointmentId);
	}
	
	@GetMapping("/getappointments/{appointmentId}")
	public Appointment getAppointmentById(@PathVariable("appointmentId") long appointmentId) throws AppointmentNotFoundException {
		 return appservice.getAppointmentById(appointmentId);
	}
	@GetMapping("/id")
	public AppointmentDetails getById(@RequestParam(value="id") long  id)
	{
		return appservice.getById(id);
	}
	
}
