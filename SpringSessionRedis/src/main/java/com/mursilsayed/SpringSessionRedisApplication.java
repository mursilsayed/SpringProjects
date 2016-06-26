package com.mursilsayed;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSessionRedisApplication {
	

	@Autowired
	private EmployeeRepository empRepo;


	public static void main(String[] args) {
		SpringApplication.run(SpringSessionRedisApplication.class, args);
	}
	
	/**
	 * Creating new Employees at system startup
	 */
	public @PostConstruct void init() {

		empRepo.save(new Employee("Mursil", "Sayed", "Software Architect"));
		empRepo.save(new Employee("Raheel", "Sayed", "Software Engineer"));
	}
	
	

}
