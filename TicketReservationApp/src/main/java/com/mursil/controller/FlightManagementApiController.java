/**
 * 
 */
package com.mursil.controller;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mursil.service.IFlightManagementService;


/**
 ** This controller exposes the Flight Management Services as REST API to airline staff only. 
 * @author Mursil
 *
 */
@RestController
@RequestMapping("/api/flightmanagement")
public class FlightManagementApiController {
	
	private static final Logger logger = 
			LoggerFactory.getLogger(FlightManagementApiController.class);

	
	@Autowired
	IFlightManagementService flightService;

	
	@RequestMapping(path ="/getdeparturefilghts" , method= RequestMethod.GET)
	protected HashMap<String,Object> getDepartureFilghts(@RequestBody HashMap<String,String> request, HttpServletRequest httpreq) 
	{
		HashMap<String,Object> response = new HashMap<String,Object>();
		try{
			
			//TODO:
			
			
		}catch(Exception e)
		{
			
		}
		
		return response;
	}
	
	@RequestMapping(path ="/getflightpassengerdetails" , method= RequestMethod.GET)
	protected HashMap<String,Object> getFlightPassengerdetails(@RequestBody HashMap<String,String> request, HttpServletRequest httpreq) 
	{
		HashMap<String,Object> response = new HashMap<String,Object>();
		try{
			
			//TODO:
			
			
		}catch(Exception e)
		{
			
		}
		
		return response;
		
	}
	
	
	@RequestMapping(path ="/cancelflight" , method= RequestMethod.GET)
	protected HashMap<String,Object> cancelFlight(@RequestBody HashMap<String,String> request, HttpServletRequest httpreq) 
	{
		HashMap<String,Object> response = new HashMap<String,Object>();
		try{
			
			//TODO:
			
			
		}catch(Exception e)
		{
			
		}
		
		return response;
		
	}
	
	

	@RequestMapping(path ="/cancelticket" , method= RequestMethod.GET)
	protected HashMap<String,Object> cancelTicket(@RequestBody HashMap<String,String> request, HttpServletRequest httpreq) 
	{
		HashMap<String,Object> response = new HashMap<String,Object>();
		try{
			
			//TODO:
			
			
		}catch(Exception e)
		{
			
		}
		
		return response;
		
	}
	
	
	
	
	
}
