package com.greenstitch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greenstitch.exceptions.CustomerException;
import com.greenstitch.model.Customer;
import com.greenstitch.repository.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepo customerRepo;

	@Override
	public Customer signUpCustomer(Customer customer) {
		
		return customerRepo.save(customer);
	}

	@Override
	public Customer getCustomerByEmail(String email) throws CustomerException {

		return customerRepo.findByEmail(email).orElseThrow(()->new CustomerException("Customer not found with the emial: "+email));
	}

}
