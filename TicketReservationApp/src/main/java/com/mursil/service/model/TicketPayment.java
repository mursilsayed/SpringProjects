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
 * Entity Class for storing payment information of ticket. 
 * @author Mursil
 *
 */
@Entity
public class TicketPayment {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;
	
	@ManyToOne
	private FlightTicket flightTicket;
	
	 @Enumerated(value = EnumType.STRING)
	 private PaymentType type;
	 
	private int paymentAmount;
	
	private String description;

	/**
	 *  Parametrized Constructor for quick initialization
	 * 
	 * @param flightTicket
	 * @param type
	 * @param paymentAmount
	 * @param description
	 */
	public TicketPayment(FlightTicket flightTicket, PaymentType type,
			int paymentAmount, String description) {
		super();
		this.flightTicket = flightTicket;
		this.type = type;
		this.paymentAmount = paymentAmount;
		this.description = description;
	}
	
	/**
	 * Default Constructor for Hibernate
	 */
	public TicketPayment(){
		
	}

	/**
	 * @return the flightTicket
	 */
	public FlightTicket getFlightTicket() {
		return flightTicket;
	}

	/**
	 * @return the type
	 */
	public PaymentType getType() {
		return type;
	}

	/**
	 * @return the paymentAmount
	 */
	public int getPaymentAmount() {
		return paymentAmount;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param flightTicket the flightTicket to set
	 */
	public void setFlightTicket(FlightTicket flightTicket) {
		this.flightTicket = flightTicket;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(PaymentType type) {
		this.type = type;
	}

	/**
	 * @param paymentAmount the paymentAmount to set
	 */
	public void setPaymentAmount(int paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	
	
}
