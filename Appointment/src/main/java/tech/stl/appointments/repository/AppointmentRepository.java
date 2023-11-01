package tech.stl.appointments.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.stl.appointments.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}
