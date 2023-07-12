package com.greenstitch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.greenstitch.exceptions.CustomerException;
import com.greenstitch.model.Customer;
import com.greenstitch.repository.CustomerRepo;
import com.greenstitch.service.CustomerService;

import jakarta.validation.Valid;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@PostMapping("/customers")
	public ResponseEntity<Customer> signUpCustomer(@Valid @RequestBody Customer customer){
		customer.setPassword(passwordEncoder.encode(customer.getPassword()));
		
		Customer registerCustomer = customerService.signUpCustomer(customer);
		
		return new ResponseEntity<>(registerCustomer,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/signIn")
	public ResponseEntity<Customer> logInCustomer(Authentication auth) throws CustomerException{
		Customer customer = customerRepo.findByEmail(auth.getName()).orElseThrow(()-> new BadCredentialsException(null));
		 return new ResponseEntity<>(customer,HttpStatus.ACCEPTED);
	}
	
}
