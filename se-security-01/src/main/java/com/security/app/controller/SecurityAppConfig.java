package com.security.app.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;
     
@Configuration
@EnableWebSecurity(debug = true)
public class SecurityAppConfig {
	
	@Autowired
	private HttpSecurity httpSecurity;
	
	
	@Bean
	public InMemoryUserDetailsManager setUpUsers() {
		 UserDetails pranayuser = User 
				.withUsername("pranay")
				.password("password")
				.roles("Admin","visitor")
				.build();
		 
		 UserDetails georgeuser = User
				 .withUsername("george")
				 .password("password")
				 .roles("customer","visitor")
				 .build();
		 return new InMemoryUserDetailsManager(pranayuser,georgeuser);	
	}
	
	
	@Bean
	public SecurityFilterChain settingUpCustomFilterChain() throws Exception {
		
		//return new DefaultSecurityFilterChain(null, null)
		
		return httpSecurity.build();
	}
	
	@Bean
	PasswordEncoder passwordencoder() {
		
		return NoOpPasswordEncoder.getInstance();
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
