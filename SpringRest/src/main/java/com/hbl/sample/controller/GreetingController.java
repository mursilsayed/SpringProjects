package com.hbl.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import com.hbl.sample.Greeting;
import com.hbl.sample.service.GreetingService;

@RestController
public class GreetingController {
	
	@Autowired
	GreetingService greetingService;
	
	@RequestMapping("/greeting")
    public HttpEntity<Greeting> greeting(
            @RequestParam(value = "name", required = false, defaultValue = "Mursil Sayed") String name) {

		
         Greeting greeting = greetingService.getStartupGreeting(name);
		 greeting.add(linkTo(methodOn(GreetingController.class).greeting(name)).withSelfRel());

		 ResponseEntity<Greeting> response =  new ResponseEntity<Greeting>(greeting, HttpStatus.OK);
		 return response;
       
       
    }

}
