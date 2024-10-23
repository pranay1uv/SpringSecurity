package com.security.app.controller;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
     
@Configuration
@EnableWebSecurity(debug = true)
public class SecurityAppConfig {
	
	
	@Bean
	public InMemoryUserDetailsManager setUpUsers() {
		 UserDetails pranayuser = User 
				.withUsername("pranay")
				.password("$2a$10$wTp5pQPhxgo9F9V0XNHQgePqHO9SitpaEAndf5SLrVwaFHy7Xj5vO")
				.roles("Admin","visitor")
				.build();
		 
		 UserDetails georgeuser = User
				 .withUsername("george")
				 .password("$2a$10$MVoxdVxjPYNL/RokzcmsuevUajzgq/etgow0BJwNuSlJbCzkgHg.u")
				 .roles("customer","visitor")
				 .build();
		 return new InMemoryUserDetailsManager(pranayuser,georgeuser);	
	}
	
	@Bean
	PasswordEncoder passwordencoder() {
		return new BCryptPasswordEncoder();
	}
	
	
//	@Bean
//	public InMemoryUserDetailsManager setUpUser() {
//		
		
//		ArrayList<GrantedAuthority> authoritiesList = new ArrayList<>();
		// In the below lines we are appending one element to the authoritiesList
//		authoritiesList.add(new SimpleGrantedAuthority("admin"));
//		authoritiesList.add(new SimpleGrantedAuthority("Visitor"));
//		
//		UserDetails newuser = new User("pranay", "password", authoritiesList);
//		
//		InMemoryUserDetailsManager inMemoryUserDetails = new InMemoryUserDetailsManager();
//		inMemoryUserDetails.createUser(newuser);
//		
//		return inMemoryUserDetails;
//		
//	}
//	
//	@Bean
//	PasswordEncoder passwordencoder() {
//		
//		return NoOpPasswordEncoder.getInstance();
//	}
	
	
}
