/**
 * 
 */
package com.mursil.service.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author Mursil
 *
 */
@Entity
public class Flight {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;
	
	@ManyToOne
	private Airline airline;
	
	private String origin;
	private String destination;
	private Date departureTime;
	private Date arrivalTime;
	private int flightDuration;
	private int noOfSeats;
	private int allowedLuggage;
	
	/**
	 * Parametrized Constructor for quick initialization
	 * 
	 * @param airline
	 * @param origin
	 * @param destination
	 * @param departureTime
	 * @param arrivalTime
	 * @param flightDuration
	 * @param noOfSeats
	 * @param allowedLuggage
	 */
	public Flight(Airline airline, String origin, String destination,
			Date departureTime, Date arrivalTime, int flightDuration,
			int noOfSeats, int allowedLuggage) {
		super();
		this.airline = airline;
		this.origin = origin;
		this.destination = destination;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.flightDuration = flightDuration;
		this.noOfSeats = noOfSeats;
		this.allowedLuggage = allowedLuggage;
	}
	
	/**
	 * Default Constructor for Hibernate
	 */
	public Flight(){}

	/**
	 * @return the airline
	 */
	public Airline getAirline() {
		return airline;
	}

	/**
	 * @return the origin
	 */
	public String getOrigin() {
		return origin;
	}

	/**
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * @return the departureTime
	 */
	public Date getDepartureTime() {
		return departureTime;
	}

	/**
	 * @return the arrivalTime
	 */
	public Date getArrivalTime() {
		return arrivalTime;
	}

	/**
	 * @return the flightDuration
	 */
	public int getFlightDuration() {
		return flightDuration;
	}

	/**
	 * @return the noOfSeats
	 */
	public int getNoOfSeats() {
		return noOfSeats;
	}

	/**
	 * @return the allowedLuggage
	 */
	public int getAllowedLuggage() {
		return allowedLuggage;
	}

	/**
	 * @param airline the airline to set
	 */
	public void setAirline(Airline airline) {
		this.airline = airline;
	}

	/**
	 * @param origin the origin to set
	 */
	public void setOrigin(String origin) {
		this.origin = origin;
	}

	/**
	 * @param destination the destination to set
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}

	/**
	 * @param departureTime the departureTime to set
	 */
	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	/**
	 * @param arrivalTime the arrivalTime to set
	 */
	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	/**
	 * @param flightDuration the flightDuration to set
	 */
	public void setFlightDuration(int flightDuration) {
		this.flightDuration = flightDuration;
	}

	/**
	 * @param noOfSeats the noOfSeats to set
	 */
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	/**
	 * @param allowedLuggage the allowedLuggage to set
	 */
	public void setAllowedLuggage(int allowedLuggage) {
		this.allowedLuggage = allowedLuggage;
	}
	
	
}
