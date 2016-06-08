package com.hbl.sample.service;

import org.springframework.stereotype.Service;

import com.hbl.sample.Greeting;
import com.hbl.sample.controller.GreetingController;

@Service
public class GreetingService {
	
	public Greeting getStartupGreeting(String name){
		
		Greeting greeting =new Greeting("Hello World, "+name);
		
		return greeting; 
	}

}
