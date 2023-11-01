package tech.stl.doctor.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class ApplicationExceptionHandler {
	@ResponseStatus(HttpStatus.BAD_REQUEST )
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String> handleException(MethodArgumentNotValidException ex)
	{
		Map<String,String> map=new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error->{
			
			map.put(error.getField(), error.getDefaultMessage());
		
		});
		return map;
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST )
	@ExceptionHandler(DoctorNotFoundException.class)
	public Map<String,String> handleIdException(DoctorNotFoundException ex)
	{
		Map<String,String> map=new HashMap<>();
			
			map.put("error message",ex.getMessage());
		
		
		return map;
	}
	@ResponseStatus(HttpStatus.BAD_REQUEST )
	@ExceptionHandler(DoctorNameNotFoundException.class)
	public Map<String,String> handleNameException(DoctorNameNotFoundException ex)
	{
		Map<String,String> map=new HashMap<>();
			
			map.put("error message",ex.getMessage());
		
		
		return map;
	
}


}
