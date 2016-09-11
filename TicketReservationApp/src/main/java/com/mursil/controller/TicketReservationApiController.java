/**
 * 
 */
package com.mursil.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mursil.service.ITicketReservationService;

/**
 * This controller exposes the Ticket Reservation Services as REST API to public. 
 * 
 * @author Mursil
 *
 */
@RestController
@RequestMapping("/api/ticketreservation")	  
public class TicketReservationApiController {

	private static final Logger logger = 
			LoggerFactory.getLogger(TicketReservationApiController.class);

	@Autowired
	ITicketReservationService ticketReservationService;
	
	
	  @RequestMapping("/findflights")	  
	  public String findFlights() {
		  
		  
		  logger.info("<=== /findflights ===>");
		
		  return "flights";
	  }
	
}
