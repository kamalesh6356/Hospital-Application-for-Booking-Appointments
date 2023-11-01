package tech.stl.appointments.entity;

public class AppointmentDetails {

	private long appointmentId;
	private String appointmentDate;
	private long id;
	private long doctorId;
	private String consultationType;
	private Patient patient;
	private Doctor doctor;
	
	public AppointmentDetails() {
		super();
	}
	public AppointmentDetails(long appointmentId, String appointmentDate, long id, long doctorId,
			String consultationType, Patient patient, Doctor doctor) {
		super();
		this.appointmentId = appointmentId;
		this.appointmentDate = appointmentDate;
		this.id = id;
		this.doctorId = doctorId;
		this.consultationType = consultationType;
		this.patient = patient;
		this.doctor = doctor;
	}
	public long getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(long appointmentId) {
		this.appointmentId = appointmentId;
	}
	public String getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(long doctorId) {
		this.doctorId = doctorId;
	}
	public String getConsultationType() {
		return consultationType;
	}
	public void setConsultationType(String consultationType) {
		this.consultationType = consultationType;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	@Override
	public String toString() {
		return "AppointmentDetails [appointmentId=" + appointmentId + ", appointmentDate=" + appointmentDate + ", id="
				+ id + ", doctorId=" + doctorId + ", consultationType=" + consultationType + ", patient=" + patient
				+ ", doctor=" + doctor + "]";
	}
	

}
