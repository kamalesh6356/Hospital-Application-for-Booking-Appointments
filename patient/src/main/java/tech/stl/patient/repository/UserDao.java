package tech.stl.patient.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tech.stl.patient.entity.User;

@Repository
public interface UserDao extends CrudRepository<User, String> {
}
