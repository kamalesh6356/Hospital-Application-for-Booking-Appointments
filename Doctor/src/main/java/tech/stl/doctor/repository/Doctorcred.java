package tech.stl.doctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.stl.doctor.entity.DoctorCredentials;

public interface Doctorcred  extends JpaRepository<DoctorCredentials, Long>{
	DoctorCredentials findByUsername(String username);

}
