package com.mursilsayed;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	/**
	 * This section defines the user accounts which can be used for authentication as well as the roles each user has.
	 * 
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication().//
				withUser("user").password("user123").roles("USER").and().//
				withUser("admin").password("admin123").roles("USER", "ADMIN");
	}

	/**
	 * This section defines the url based security policy for the app.
	 * <p>
	 * <ul>
	 * <li>BASIC authentication is supported (enough for this REST-based demo).</li>
	 * <li>/employees is secured using URL security shown below.</li>
	 * <li>CSRF headers are disabled since we are only testing the REST interface, not a web one.</li>
	 * </ul>
	 * NOTE: GET is not shown which defaults to permitted.
	 *
	 * @param http
	 * @throws Exception
	 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.web.builders.HttpSecurity)
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable();
		
		http
			.httpBasic().and()
			.antMatcher("/emp/**")
				.authorizeRequests()
					.anyRequest().hasRole("ADMIN");
//		
//		
//		
//		http.httpBasic().and().authorizeRequests().//
//				antMatchers(HttpMethod.POST, "/employees").hasRole("ADMIN").//
//				antMatchers(HttpMethod.POST, "/addEmployee").hasRole("ADMIN").//
//				antMatchers(HttpMethod.PUT, "/employees/**").hasRole("ADMIN").//
//				antMatchers(HttpMethod.PATCH, "/employees/**").hasRole("ADMIN").and().//
//				csrf().disable();
	}


}
