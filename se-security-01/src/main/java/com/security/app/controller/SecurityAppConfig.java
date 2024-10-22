package com.security.app.controller;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

// This is class is going to create a security chain filter
// Sceurity chain filter has a list of filters
// the primary purpose of this security filter chain
// is to validate a client request
// i.e before hitting the one our end points
// these filters will com into the picture based in the type of request
// and act accordingly
// Note: if any of the filters doesnt have ny work or role
// those filters will be skipped
@Configuration
@EnableWebSecurity(debug = true)
public class SecurityAppConfig {
	
	
	@Bean
	public InMemoryUserDetailsManager setUpUser() {
		
		ArrayList<GrantedAuthority> authoritiesList = new ArrayList<>();
		authoritiesList.add(new SimpleGrantedAuthority("admin"));
		authoritiesList.add(new SimpleGrantedAuthority("Visitor"));
		
		UserDetails newuser = new User("pranay", "password", authoritiesList);
		
		InMemoryUserDetailsManager inMemoryUserDetails = new InMemoryUserDetailsManager();
		inMemoryUserDetails.createUser(newuser);
		
		return inMemoryUserDetails;
		
	}
	
	@Bean
	PasswordEncoder passwordencoder() {
		
		return NoOpPasswordEncoder.getInstance();
	}
	
	
}
