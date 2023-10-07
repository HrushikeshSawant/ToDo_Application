package com.hrushikesh.ToDo_Application.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = ResourceNotFoundException.class)
	public ResponseEntity<Object> resourceNotFoundException(ResourceNotFoundException ex) {
		String errMsg = ex.getLocalizedMessage();

		if (errMsg == null)
			errMsg = ex.toString();

		ErrorMsgDesciption emd = new ErrorMsgDesciption(HttpStatus.NOT_FOUND.toString(), errMsg);

		return new ResponseEntity<Object>(emd, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<Object> handleExeption(Exception ex) {
		String errMsg = ex.getLocalizedMessage();

		if (errMsg == null)
			errMsg = ex.toString();

		ErrorMsgDesciption emd = new ErrorMsgDesciption(HttpStatus.INTERNAL_SERVER_ERROR.toString(), errMsg);

		return new ResponseEntity<Object>(emd, HttpStatus.NOT_FOUND);
	}

}
