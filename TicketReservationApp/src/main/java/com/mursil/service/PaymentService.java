/**
 * 
 */
package com.mursil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mursil.service.model.TicketPaymentRespository;

/**
 * @author Mursil
 *
 */
@Service
 class PaymentService implements IPaymentService {
	
	@Autowired
	TicketPaymentRespository ticketPaymentRepository;
	

	
	
	
}
