/**
 * 
 */
package com.mursil.service.model;

/**
 *  Enum for representing the Different Status of Ticket. 
 * @author Mursil
 *
 */
public enum TicketStatus {
	
	TR ("RESERVED"), //Ticket is reserved by the customer
	BC ("BOOKING_CANCELLED"), // Ticket Booking is cancelled by the customer
	TC ("CANCELLED"), //Ticket Cancelled  by staff
	BP ("BOARDING_PASS_ISSUED");// Boarding pass issued
	
	private final String name; 
	
    private TicketStatus(String s) {
        name = s;
    }
	
    public String value() {
        return name();
    }
    
    public String toString() {
        return this.name;
     }

    public static TicketStatus fromValue(String v) {
        return valueOf(v);
    }

}
