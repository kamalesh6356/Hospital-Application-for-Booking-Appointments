package tech.stl.appointments.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import tech.stl.appointments.apicall.ApiCall;
import tech.stl.appointments.entity.Appointment;
import tech.stl.appointments.entity.AppointmentDetails;
import tech.stl.appointments.entity.Doctor;
import tech.stl.appointments.entity.Patient;
import tech.stl.appointments.entity.ResponseTemplate;
import tech.stl.appointments.exception.AppointmentNotFoundException;
import tech.stl.appointments.repository.AppointmentRepository;
import tech.stl.appointments.service.AppointmentService;
@Service
public class AppointmentServiceImpl implements AppointmentService {
	@Autowired
	private AppointmentRepository apprepo;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private ApiCall apiCall;
	
	

	@Override
	public Appointment saveAppointments(Appointment appointment) {
		// TODO Auto-generated method stub
		return apprepo.save(appointment);
	}

	@Override
	public List<Appointment> getAllAppointments() {
		// TODO Auto-generated method stub
		return apprepo.findAll();
	}

	@Override
	public void deleteAppointments(long appointmentId) {
		// TODO Auto-generated method stub
		apprepo.deleteById(appointmentId);
		
	}

	@Override
	public Appointment updateAppointments(Appointment appointment, long appointmentId) {
		// TODO Auto-generated method stub
		Appointment apt=apprepo.findById(appointmentId).get();
		if(Objects.nonNull(appointment.getAppointmentDate()) && !"".equalsIgnoreCase(appointment.getAppointmentDate()))
		{
	         apt.setAppointmentDate(appointment.getAppointmentDate());
		}
		if(Objects.nonNull(appointment.getPatientName()) && !"".equalsIgnoreCase(appointment.getPatientName()))
		{
	         apt.setPatientName(appointment.getPatientName());
		}
		
		return apprepo.save(appointment);
		}

	

	@Override
	public Appointment getAppointmentById(long appointmentId) throws AppointmentNotFoundException {
		// TODO Auto-generated method stub
		Appointment appointment= apprepo.findById(appointmentId).get();
		if(appointment!=null) {
			return appointment;
			}
		else
		{
			throw new AppointmentNotFoundException("Appointment not found with id :"+appointmentId);
		}
		
	}

	@Override
	public AppointmentDetails getById(long id) {
		// TODO Auto-generated method stub
		Appointment appointment=apprepo.findById(id).orElse(null);
//		Patient patient=apiCall.getPatientDetails(appointment.getId());
//		Doctor doctor=apiCall.getDoctorDetails(appointment.getDoctorId());
		AppointmentDetails appointmentDetails=new AppointmentDetails();
		BeanUtils.copyProperties(appointment, appointmentDetails);
//		appointmentDetails.setPatient(patient);
//		appointmentDetails.setDoctor(doctor);
		return appointmentDetails;
	}

	
	}

	


