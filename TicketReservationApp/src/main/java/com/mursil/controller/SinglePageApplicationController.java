package com.mursil.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * This controller expose the SPA application. It loads the SPA application(UI)
 * Once the SPA is loaded in the Client's browser, all subsequent calls
 * are made to REST Controllers( FlightManagementController or TicketReservationController)
 * 
 * @author Mursil
 *
 */
@Controller
@RequestMapping("/app")
public class SinglePageApplicationController {
	

	  private static final Logger logger = 
			LoggerFactory.getLogger(SinglePageApplicationController.class);

	
	  /**
	   * This controller loads the main Application. This endpoint is publically accessible
	   * 
	   * @param request
	   * @param model
	   * @return
	   */
      @RequestMapping(value="/home", method=RequestMethod.GET)	  
      public String applicationHome(HttpServletRequest request,Model model) {
  
		  
		  logger.info("<=== HOME PAGE ===>");
		
		  return "home";
	  }

	  /**
	   * This Controller is only for testing/debugging purpose. 
	   * //TODO: Should be removed before going into production
	   * 
	   * @param request
	   * @param model
	   * @return
	   */
	  @RequestMapping(value="/test", method=RequestMethod.GET)
	  @ResponseBody
	  public String applicationTestPage(HttpServletRequest request,Model model) {
		  
		  logger.info("<=== Test Controller end point ===>");
		
		  return "Hello World from Test Controller";
	  }
}
