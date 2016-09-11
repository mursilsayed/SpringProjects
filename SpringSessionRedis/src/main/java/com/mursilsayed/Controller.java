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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {
	
	@Autowired
	private EmployeeRepository empRepo;
	
	@RequestMapping(path ="/emp/addEmployee" , method= RequestMethod.POST)
	protected HashMap<String,String> addNewEmployee(@RequestBody HashMap<String,String> request,HttpSession session) 
	{
	
		HashMap<String,String> sessionDetails = new HashMap<String,String>();
		sessionDetails.put("sessionID", session.getId());
		sessionDetails.put("MaxInactiveInterval", String.valueOf(session.getMaxInactiveInterval()));
		sessionDetails.put("Creation Time", String.valueOf(session.getCreationTime()));
		
		
		
		
		empRepo.save(new Employee(request.get("firstName"), request.get("lastName"), request.get("title")));
		return sessionDetails;
	}

	@RequestMapping(path ="/emp/allEmployees" , method= RequestMethod.GET)
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
	
	
	@RequestMapping("/emp/session")
	String uid(HttpSession session) {
		UUID uid = (UUID) session.getAttribute("uid");
		if (uid == null) {
			uid = UUID.randomUUID();
		}
		session.setAttribute("uid", uid);
		return uid.toString();
}
	
	/**
	 * This method displays a greeting message to the caller and displays 
	 * the method counter along with the UUID that is allocated to the user
	 * @param session
	 * @return
	 */
	@RequestMapping("/greetings/getgreeting")
	HashMap<String,String> getGreetings(HttpSession session){
		
		HashMap<String,String> result=new HashMap<String,String>();
		
		result.put("greetingMessage","Hello World!");
		result.put("sessionId", session.getId());
		result.put("methodCounter", "1");
		
		
		if(session.isNew())
		{
			session.setAttribute("methodCounter",1);
		}
		else // Session already Present
		{
			String greetingName = (String)session.getAttribute("greetingMessage");
			Integer methodCounter = (Integer)session.getAttribute("methodCounter");
			
			if(greetingName!=null)
				result.put("greetingMessage",greetingName);
			
			methodCounter++;
			result.put("methodCounter", methodCounter.toString());
			session.setAttribute("methodCounter",methodCounter);
			
				
		}
		
		return result;
		
	}
	
	@RequestMapping(path="/greetings/setgreeting",method=RequestMethod.POST)
	HashMap<String,String> submitNameForGreeting(@RequestParam(value = "greetingMessage", required = false, defaultValue = "Default Message") String greetingMessage,HttpSession session)
	{
		HashMap<String,String> result=new HashMap<String,String>();
		
		result.put("greetingMessage",greetingMessage);
		result.put("sessionId", session.getId());
		
		session.setAttribute("greetingMessage", greetingMessage);
		
		
		return result;
		
		
		
	}
	
}
