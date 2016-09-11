/**
 * 
 */
package com.mursil.service.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * FlightTicket Entity that contains the information about FLightTickets 
 * of customers.
 * 
 * @author Mursil
 *
 */
@Entity
public class FlightTicket {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;
	
	@ManyToOne
	private FlightDetails flightDetails;
	
	@ManyToOne
	private Customer customer;
	
	 @Enumerated(value = EnumType.STRING)
	 private TicketStatus status;
	
	 private int seatNumber;

	/**
	 *  Parametrized Constructor for quick initialization
	 * 
	 * @param flightDetails
	 * @param customer
	 * @param status
	 * @param seatNumber
	 */
	public FlightTicket(FlightDetails flightDetails, Customer customer,
			TicketStatus status, int seatNumber) {
		super();
		this.flightDetails = flightDetails;
		this.customer = customer;
		this.status = status;
		this.seatNumber = seatNumber;
	}
	
	/**
	 * Default Constructor for Hibernate
	 * 
	 */
	public FlightTicket(){
		
	}

	/**
	 * @return the flightDetails
	 */
	public FlightDetails getFlightDetails() {
		return flightDetails;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @return the status
	 */
	public TicketStatus getStatus() {
		return status;
	}

	/**
	 * @return the seatNumber
	 */
	public int getSeatNumber() {
		return seatNumber;
	}

	/**
	 * @param flightDetails the flightDetails to set
	 */
	public void setFlightDetails(FlightDetails flightDetails) {
		this.flightDetails = flightDetails;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(TicketStatus status) {
		this.status = status;
	}

	/**
	 * @param seatNumber the seatNumber to set
	 */
	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}
}
