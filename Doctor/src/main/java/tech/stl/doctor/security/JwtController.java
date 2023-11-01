package tech.stl.doctor.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tech.stl.doctor.entity.DoctorCredentials;


@RestController
@RequestMapping
public class JwtController {
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private JwtUtils jwtUtil;
	@Autowired
	private AuthenticationManager authenticationManager;
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ResponseEntity<JwtResponse> generateToken(@RequestBody DoctorCredentials doc) throws Exception
	{
		System.out.println(doc);
		try {
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(doc.getUsername(),doc.getPassword()));
		} catch(BadCredentialsException e)
		{
			e.printStackTrace();
			throw new Exception("Bad Credentials");
		}
	UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(doc.getUsername());
	String token = this.jwtUtil.generateToken(userDetails);
	System.out.println("JWT"+token);
	return ResponseEntity.ok(new JwtResponse(token));
	}

}
