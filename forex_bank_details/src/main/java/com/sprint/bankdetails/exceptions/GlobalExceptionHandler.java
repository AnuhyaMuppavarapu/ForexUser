package com.sprint.bankdetails.exceptions;

import com.sprint.bankdetails.dto.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ExceptionDTO> handleUsersNotFoundException(RuntimeException e){
		return  new ResponseEntity<>(new ExceptionDTO(e.getMessage()),HttpStatus.NOT_FOUND);
    }


}