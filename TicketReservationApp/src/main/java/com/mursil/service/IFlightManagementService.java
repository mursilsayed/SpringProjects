/**
 * 
 */
package com.mursil.service;

import java.util.List;

import com.mursil.service.model.FlightDetails;
import com.mursil.service.model.FlightTicket;

/**
 * Flight Management Service Interface that will be used by the Airline Staff
 * 
 * @author Mursil
 *
 */
public interface IFlightManagementService {
	
	public List<FlightDetails> GetDepartureFlightList();
	public List<FlightTicket> GetFlightPassengersDetails();
	public void CancelFlight(int flightId);
	public void CancelTicket(int ticketId);
	

}
