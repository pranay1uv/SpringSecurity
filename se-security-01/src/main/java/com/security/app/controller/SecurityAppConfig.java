package com.security.app.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

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

}
