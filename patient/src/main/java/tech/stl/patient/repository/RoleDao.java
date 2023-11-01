package tech.stl.patient.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tech.stl.patient.entity.Role;

@Repository
public interface RoleDao extends CrudRepository<Role, String> {

}
