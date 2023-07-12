package com.greenstitch.exceptions;

import java.lang.reflect.Method; 
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<MyErrorDetails> CustomerException(CustomerException ad,WebRequest wrq){
		
		MyErrorDetails err=new MyErrorDetails();
		err.setLocaldateTime(LocalDateTime.now());
		err.setMessage(ad.getMessage());
		err.setDescription(wrq.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_GATEWAY);
	}

	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> MethodArgumentNotValidException(MethodArgumentNotValidException ad,WebRequest wrq){
		
		MyErrorDetails err=new MyErrorDetails();
		err.setLocaldateTime(LocalDateTime.now());
		err.setMessage(ad.getMessage());
		err.setDescription(wrq.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_GATEWAY);
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> NoHandlerFoundException(NoHandlerFoundException ad,WebRequest wrq){
		
		MyErrorDetails err=new MyErrorDetails();
		err.setLocaldateTime(LocalDateTime.now());
		err.setMessage(ad.getMessage());
		err.setDescription(wrq.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_GATEWAY);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> AllException(Exception ad,WebRequest wrq){
		
		MyErrorDetails err=new MyErrorDetails();
		err.setLocaldateTime(LocalDateTime.now());
		err.setMessage(ad.getMessage());
		err.setDescription(wrq.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_GATEWAY);
	}
	
}
