/**
 * 
 */
package com.mursil;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * This class configures Spring Security for the Public end points
 * needed for ticket reservation . Customers will be authenticated by 
 * Social Service(Twitter/LinkedIn/Google+)
 *  
 * 
 * @author Mursil
 *
 */
@Configuration
@EnableWebSecurity
 class SecurityConfigurationPublic extends WebSecurityConfigurerAdapter {
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
	

		http
		.httpBasic().and()
		.antMatcher("/api/ticketreservation/**")
	      .authorizeRequests()
	        //.antMatchers("/api/ticketreservation/findflights").hasRole("PUBLIC")
	        .anyRequest().authenticated();
		
		
	       
		
	}

	
	/* 
	 * This method will provide a local AuthenticationManager for authenticating public 
	 * via Twitter/Google+/LinkedIn. 
	 * 
	 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder)
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		
		/**
		 * TODO: This code should be replaced with Social Media verification. 
		 */
		 auth
	      .inMemoryAuthentication()
	          .withUser("public").password("publicuser").roles("PUBLIC");
	         
	         
		
	}
}
