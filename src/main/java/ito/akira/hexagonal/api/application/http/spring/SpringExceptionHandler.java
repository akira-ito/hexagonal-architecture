package ito.akira.hexagonal.api.application.http.spring;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import ito.akira.hexagonal.api.core.exceptions.StudentNotFoundException;

@ControllerAdvice
public class SpringExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ StudentNotFoundException.class })
	public ResponseEntity<Object> handleAccessDeniedException(StudentNotFoundException ex, WebRequest request) {
		return new ResponseEntity<Object>(ex.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND);
	}
}
