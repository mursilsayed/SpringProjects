/**
 * 
 */
package com.mursil.service;

/**
 * @author Mursil
 *
 */
public interface IEmailService {

	public void SendTicketEmail();
	public void SendEarlyCheckoutAlertEmail();
	public void SendTicketCancellationEmail();
	public void SendFlightCancellationEamil();
	public void SendBookingCancellationEmail();
	
	
	
}
