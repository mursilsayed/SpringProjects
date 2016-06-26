package com.mursilsayed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {
	
	@Autowired
	private EmployeeRepository empRepo;
	
	@RequestMapping(path ="/addEmployee" , method= RequestMethod.POST)
	protected HashMap<String,String> addNewEmployee(@RequestBody HashMap<String,String> request,HttpSession session) 
	{
	
		HashMap<String,String> sessionDetails = new HashMap<String,String>();
		sessionDetails.put("sessionID", session.getId());
		sessionDetails.put("MaxInactiveInterval", String.valueOf(session.getMaxInactiveInterval()));
		sessionDetails.put("Creation Time", String.valueOf(session.getCreationTime()));
		
		
		
		
		empRepo.save(new Employee(request.get("firstName"), request.get("lastName"), request.get("title")));
		return sessionDetails;
	}

	@RequestMapping(path ="/allEmployees" , method= RequestMethod.GET)
	protected HashMap<String,String> GetAllEmployees(HttpSession session) 
	{
		Iterable<Employee> list = empRepo.findAll();
		
		//List<HashMap<String,String>> result = new ArrayList<HashMap<String,String>>();
		
		//list.forEach(item->{result.add(item);});
		HashMap<String,String> sessionDetails = new HashMap<String,String>();
		sessionDetails.put("sessionID", session.getId());
		sessionDetails.put("MaxInactiveInterval", String.valueOf(session.getMaxInactiveInterval()));
		sessionDetails.put("Creation Time", String.valueOf(session.getCreationTime()));
		
		
		
		
		return sessionDetails;
		
		
	}
	
	
	@RequestMapping("/session")
	String uid(HttpSession session) {
		UUID uid = (UUID) session.getAttribute("uid");
		if (uid == null) {
			uid = UUID.randomUUID();
		}
		session.setAttribute("uid", uid);
		return uid.toString();
}
}
