package tech.stl.appointments.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Apppointments")
public class Appointment {
	@Id
	private long appointmentId;
	@DateTimeFormat(pattern="dd-MM-yyyy")
	@NotNull(message = "Please provide a date")
	private String appointmentDate;
	public Appointment(long appointmentId, @NotNull(message = "Please provide a date") String appointmentDate,
			@NotNull(message = "Consultation type cannot be null") String consultationType, long id, long doctorId) {
		super();
		this.appointmentId = appointmentId;
		this.appointmentDate = appointmentDate;
		this.patientName = consultationType;
//		this.id = id;
//		this.doctorId = doctorId;
	}
	@NotNull(message = "Consultation type cannot be null")
	private String patientName;
	
//	private long id;
//	private long doctorId;
	private String message;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public long getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(long appointmentId) {
		this.appointmentId = appointmentId;
	}
	public Appointment() {
		super();
	}
	
//	public long getDoctorId() {
//		return id;
//	}
//	public void setDoctorId(long doctorId) {
//		this.id = doctorId;
//	}
//	public long getId() {
//		return appointmentId;
//	}
//	public void setId(long id) {
//		this.appointmentId = id;
//	}
	public String getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	
	
	
	
	

}
