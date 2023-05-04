package rw.user.notes.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<ApplicationException> handleApplicationRequestException(ApplicationRequestException e){
		
		//Create a payload that we will send in the response entity
		ApplicationException applicationException= new ApplicationException(
				e.getMessage(),
				e, 
				HttpStatus.BAD_REQUEST);
		//return the actual response entity
		
		return new ResponseEntity<>(applicationException, HttpStatus.BAD_REQUEST);
	}
	
//	@ExceptionHandler
//	public ResponseEntity<ApplicationException> handleApplicationException(ApplicationException e){
//		ApplicationException applicationException = new ApplicationException(
//				e.getMessage(), 
//				e,
//				HttpStatus.NOT_FOUND);
//		
//		return new ResponseEntity<>(applicationException, HttpStatus.NOT_FOUND);
//	}
}
