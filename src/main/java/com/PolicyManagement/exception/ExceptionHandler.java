package com.PolicyManagement.exception;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
@RestController
@ControllerAdvice
public class ExceptionHandler {
	@org.springframework.web.bind.annotation.ExceptionHandler(value = PolicyMaturedException.class)
	public ResponseEntity handleMaximunLimitReachedException() {
		APIError error = new APIError(400, "maximum limit reached");
		return new ResponseEntity<APIError>(error,HttpStatus.BAD_REQUEST);
	}
}
