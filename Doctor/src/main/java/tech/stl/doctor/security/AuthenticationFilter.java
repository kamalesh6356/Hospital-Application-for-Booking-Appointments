package tech.stl.doctor.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;


@Component
public class AuthenticationFilter extends OncePerRequestFilter {
	@Autowired
	private JwtUtils jwtutil;
	@Autowired
	private CustomUserDetailsService customUserDetails;
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String authHeader=request.getHeader("Authorization");
		String token=null;
		String username=null;
	
		if(authHeader !=null && authHeader.startsWith("Bearer "))
		{
			token=authHeader.substring(7);
			username=jwtutil.extractUsername(token);
		}
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null)
		{
			
			UserDetails userDetails= customUserDetails.loadUserByUsername(username);
			if(jwtutil.validateToken(token, userDetails)) {
				UsernamePasswordAuthenticationToken authenticationToken= new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
				authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authenticationToken);
			}
		}
			
    filterChain.doFilter(request, response);		
	}
	}
	


