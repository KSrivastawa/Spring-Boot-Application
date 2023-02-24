package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	 @ExceptionHandler(StudentException.class)
	    public ResponseEntity<MyError> studentExceptionHandler(StudentException se, WebRequest request) {

	        MyError myError = new MyError();
	        myError.setMessage(se.getMessage());
	        myError.setLocalDateTime(request.getDescription(false));
	        myError.setDescription("Student Exception");

	        return new ResponseEntity<MyError>(myError, HttpStatus.BAD_REQUEST);
	    }

	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<MyError> globalExceptionHandler(Exception e, WebRequest request) {

	        MyError myError = new MyError();
	        myError.setMessage(e.getMessage());
	        myError.setLocalDateTime(request.getDescription(false));
	        myError.setDescription("Global Exception");

	        return new ResponseEntity<MyError>(myError, HttpStatus.BAD_REQUEST);
	    }
}
