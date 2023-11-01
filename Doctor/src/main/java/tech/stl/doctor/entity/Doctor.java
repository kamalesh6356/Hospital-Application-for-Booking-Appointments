package tech.stl.doctor.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Doctor")
public class Doctor {
	@Id
	private long doctorId;
	@NotNull(message="name cannot be null")
	private String name;
	@NotNull(message="specialisation cannot be null")
	private String specialisation;
	private long appointmentId;
	
	
	
	public Doctor(long id) {
		super();
		this.appointmentId = id;
	}
	public Doctor() {
		super();
	}
	public Doctor(long doctorId, @NotNull(message = "name cannot be null") String name,
			@NotNull(message = "specialisation cannot be null") String specialisation, long id) {
		super();
		this.doctorId = doctorId;
		this.name = name;
		this.specialisation = specialisation;
		this.appointmentId = id;
	}
	
	public long getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(long appointmentId) {
		this.appointmentId = appointmentId;
	}
	public long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(long doctorId) {
		this.doctorId = doctorId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpecialisation() {
		return specialisation;
	}
	public void setSpecialisation(String specialisation) {
		this.specialisation = specialisation;
	}
	

}
