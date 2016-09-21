/**
 * 
 */
package com.mursilsayed;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mursilsayed.sessionobject.ApplicationParameters;
import com.mursilsayed.sessionobject.ApplicationParametersService;

/**
 * @author Mursil
 *
 */
@RestController
public class SimpleGreetingController {

	@Autowired
	ServerUDID serverID;
	
	@Autowired
	ApplicationParametersService paramService;
	
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
		result.put("serverID", serverID.getServerID());
		
		
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
	
	@RequestMapping("/greetings/getgreeting/{key}")
	HashMap<String,String> getGreeting(@PathVariable("key")String key, HttpSession session){
		
		
		HashMap<String,String> result=new HashMap<String,String>();
		ApplicationParameters params= paramService.GetParameterValueInString(key);
		result.put(key, params.getParam_value());
		result.put("greetingMessage","Hello World!");
		result.put("sessionId", session.getId());
		result.put("serverID", serverID.getServerID());
		return result;
		
		
	}
	
	@RequestMapping(path="/greetings/setgreeting",method=RequestMethod.POST)
	HashMap<String,String> submitNameForGreeting(@RequestParam(value = "greetingMessage", required = false, defaultValue = "Default Message") String greetingMessage,HttpSession session)
	{
		HashMap<String,String> result=new HashMap<String,String>();
		
		result.put("greetingMessage",greetingMessage);
		result.put("sessionId", session.getId());
		result.put("serverID", serverID.getServerID());
		
		session.setAttribute("greetingMessage", greetingMessage);
		
		
		return result;
		
		
		
	}
}
