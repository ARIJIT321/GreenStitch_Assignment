package com.greenstitch.service;

import java.lang.StackWalker.Option;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import java.util.List;

import com.greenstitch.model.Customer;
import com.greenstitch.repository.CustomerRepo;


 
public class CustomerUserDetailsService implements UserDetailsService{

	@Autowired
	private CustomerRepo customerRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Customer> opt = customerRepo.findByEmail(username);
		if(opt.isPresent()) {
			Customer customer = opt.get();
		    List<GrantedAuthority> authorities = new ArrayList<>();
		    
		    return new User(customer.getEmail(), customer.getPassword(), authorities);
		}else {
			throw new BadCredentialsException("Customer detail not found with username: "+username);
		}
	}

}
