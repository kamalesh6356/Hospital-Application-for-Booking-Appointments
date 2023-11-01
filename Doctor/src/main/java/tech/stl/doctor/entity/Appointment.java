package tech.stl.doctor.entity;

import javax.persistence.Id;

public class Appointment { 
	
	public Appointment() {
		super();
	}
	public Appointment(long id, String appointmentDate, String consultationType, String patientName, long doctorId) {
		super();
		this.appointmentId = id;
		this.appointmentDate = appointmentDate;
		this.consultationType = consultationType;
		this.patientName = patientName;
		this.doctorId = doctorId;
	}
	private long appointmentId;
	private String appointmentDate;
	private String consultationType;
	private String patientName;
	private long doctorId;
	public long getId() {
		return appointmentId;
	}
	public void setId(long id) {
		this.appointmentId = id;
	}
	public String getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public String getConsultationType() {
		return consultationType;
	}
	public void setConsultationType(String consultationType) {
		this.consultationType = consultationType;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(long doctorId) {
		this.doctorId = doctorId;
	}

}
