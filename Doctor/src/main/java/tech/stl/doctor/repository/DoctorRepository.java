package tech.stl.doctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.stl.doctor.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long>{
	public Doctor findByName(String name);

}
