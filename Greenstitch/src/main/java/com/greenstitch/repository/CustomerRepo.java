package com.greenstitch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greenstitch.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{

	public Customer findByEmail(String email);
	
}
