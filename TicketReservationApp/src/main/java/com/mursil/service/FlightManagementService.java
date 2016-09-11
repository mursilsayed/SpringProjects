/**
 * 
 */
package com.mursil.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mursil.service.model.FlightDetails;
import com.mursil.service.model.FlightDetailsRepository;
import com.mursil.service.model.FlightTicket;

/**
 * @author Mursil
 *
 */
@Service
 class FlightManagementService implements IFlightManagementService {

	 @Autowired
	 IEmailService emailService;
	 
	 @Autowired
	 IPaymentService paymentService;
	 
	 @Autowired 
	 FlightDetailsRepository flightDetailsRepository;

	@Override
	public List<FlightDetails> GetDepartureFlightList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FlightTicket> GetFlightPassengersDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void CancelFlight(int flightId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void CancelTicket(int ticketId) {
		// TODO Auto-generated method stub
		
	}
	 
	 
	 
	 
}
