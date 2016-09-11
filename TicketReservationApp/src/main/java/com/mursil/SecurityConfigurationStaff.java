/**
 * 
 */
package com.mursil;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


/**
 * This class configures a Spring Security Filter for providing LDAP based authentication 
 * to airline staff. All the services/end points that are exposed to airline
 * staff will be authenticated via this filter. 
 *  
 * 
 * @author Mursil
 *
 */
@Configuration
@EnableWebSecurity
@Order(SecurityProperties.BASIC_AUTH_ORDER - 10)
 class SecurityConfigurationStaff extends WebSecurityConfigurerAdapter {
	
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
	
		http.csrf().disable();
		
		http
			.httpBasic().and()
			.antMatcher("/api/flightmanagement/**")
				.authorizeRequests()
					.anyRequest().authenticated();
				
						
	}
	
	
	

	/* 
	 * This method will provide a local AuthenticationManager for authenticating airline staff
	 * via there internal Identity management System. 
	 * 
	 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder)
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {

		/**
		 * TODO: This code should be replaced with LDAP verification. 
		 */
      auth
      .inMemoryAuthentication()
          .withUser("staff").password("staffuser").roles("STAFF");
         
	
	}

}
