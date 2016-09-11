/**
 * 
 */
package com.mursil.service.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


/**
 * Flight Details Entity that contains specific information about 
 * every flight. 
 * 
 * @author Mursil
 *
 */
@Entity
public class FlightDetails {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;
	
	@ManyToOne
	private Flight flight;
	
	 @Enumerated(value = EnumType.STRING)
	 private FlightStatus status;
	 
	 private Date departureDate;
	 
	 private Date remainingSeats;
	 
	 private int seatPrice;

	/**
	 * Parametrized Constructor for quick initialization
	 * 
	 * @param flight
	 * @param status
	 * @param departureDate
	 * @param remainingSeats
	 * @param seatPrice
	 */
	public FlightDetails(Flight flight, FlightStatus status,
			Date departureDate, Date remainingSeats, int seatPrice) {
		super();
		this.flight = flight;
		this.status = status;
		this.departureDate = departureDate;
		this.remainingSeats = remainingSeats;
		this.seatPrice = seatPrice;
	}
	 
	 /**
	  * Default Constructor for Hibernate
	  */
	 public FlightDetails(){
		 
	 }

	/**
	 * @return the flight
	 */
	public Flight getFlight() {
		return flight;
	}

	/**
	 * @return the status
	 */
	public FlightStatus getStatus() {
		return status;
	}

	/**
	 * @return the departureDate
	 */
	public Date getDepartureDate() {
		return departureDate;
	}

	/**
	 * @return the remainingSeats
	 */
	public Date getRemainingSeats() {
		return remainingSeats;
	}

	/**
	 * @return the seatPrice
	 */
	public int getSeatPrice() {
		return seatPrice;
	}

	/**
	 * @param flight the flight to set
	 */
	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(FlightStatus status) {
		this.status = status;
	}

	/**
	 * @param departureDate the departureDate to set
	 */
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	/**
	 * @param remainingSeats the remainingSeats to set
	 */
	public void setRemainingSeats(Date remainingSeats) {
		this.remainingSeats = remainingSeats;
	}

	/**
	 * @param seatPrice the seatPrice to set
	 */
	public void setSeatPrice(int seatPrice) {
		this.seatPrice = seatPrice;
	}
	
	
	
}
