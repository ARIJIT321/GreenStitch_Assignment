package com.greenstitch.service;

import com.greenstitch.exceptions.CustomerException;
import com.greenstitch.model.Customer;

public interface CustomerService {
	
	public Customer signUpCustomer(Customer customer);
	
	public Customer getCustomerByEmail(String email) throws CustomerException;

}
