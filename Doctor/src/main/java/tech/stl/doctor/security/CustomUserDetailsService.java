package tech.stl.doctor.security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import tech.stl.doctor.entity.DoctorCredentials;
import tech.stl.doctor.repository.Doctorcred;
@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private Doctorcred doctorcred;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		DoctorCredentials doc=doctorcred.findByUsername(username);
		return new org.springframework.security.core.userdetails.User(doc.getUsername(),doc.getPassword(),new ArrayList<>());
		
		
	}

}
